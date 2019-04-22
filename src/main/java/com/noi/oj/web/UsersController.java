package com.noi.oj.web;

import com.noi.oj.domain.Users;
import com.noi.oj.service.UsersService;
import com.noi.oj.utils.IpUtil;
import com.noi.oj.utils.JwtUtil;
import com.noi.oj.utils.Sha2Util;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UsersController extends BaseController{

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map<String,Object> register(@RequestBody Users users,HttpServletRequest request)
    {
        msg.clear();
        try {
            if(usersService.selectByEmail(users.getEmail())!=null)
            {
                msg.put("code","0");
                msg.put("msg","账号已存在");
                return msg;
            }
            users.setIp(IpUtil.getIp(request));
            if(usersService.insertSelective(users)>0)
            {
                msg.put("code","1");
                msg.put("msg","成功");
            }else {
                msg.put("code","0");
                msg.put("msg","失败");
            }
        } catch (Exception e) {
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(@RequestBody Users users)
    {
        msg.clear();
        try {
            Users findUsers = usersService.selectByEmail(users.getEmail());
            if(findUsers==null){
                msg.put("code","0");
                msg.put("msg","用户不存在");
                return msg;
            }
            if(Sha2Util.SHA256(users.getPassword()).equals(findUsers.getPassword()))
            {
                JwtUtil jwtUtil = new JwtUtil();
                String token = jwtUtil.createJWT(findUsers.getUserId().toString(),findUsers.getEmail(),1000*60*60*24*24);
                msg.put("code","1");
                msg.put("msg","成功");
                msg.put("token",token);
                return msg;
            }else{
                msg.put("code","0");
                msg.put("msg","密码错误");
            }
        } catch (Exception e) {
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Map<String,Object> getUserInfo(HttpServletRequest request){
        msg.clear();
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        Users users = usersService.selectUserInfo(userId);
        if(users!=null){
            msg.put("code","1");
            msg.put("msg","成功");
            msg.put("data",users);
        }else{
            msg.put("code","0");
            msg.put("msg","失败");
        }
        return msg;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Map<String,Object> getdetail(@RequestParam("id") Long userId){
        Users users = usersService.selectByPrimaryKey(userId);
        if(users!=null)
            setMsg(1,null,users);
        else
            setMsg(0,null,null);
        return msg;
    }

    @RequestMapping(value = "/modified",method = RequestMethod.POST)
    public Map<String,Object> modified(@RequestBody Users users, HttpServletRequest request)
    {
        msg.clear();
        Long usersId=Long.parseLong(request.getAttribute("userId").toString());
        users.setUserId(usersId);
        if(usersService.updateByPrimaryKeySelective(users)>0)
        {
            msg.put("code","1");
            msg.put("msg","成功");
        }else{
            msg.put("code","0");
            msg.put("msg","失败");
        }
        return msg;
    }

    @RequestMapping(value = "/reset",method = RequestMethod.POST)
    public Map<String,Object> reset(@RequestBody Map<String,Object> record,HttpServletRequest request)
    {
        msg.clear();
        Long usersId = Long.parseLong(request.getAttribute("userId").toString());
        String password = record.get("password").toString();
        String resetPassword = record.get("resetPassword").toString();
        Users users = usersService.selectPasswordByPrimaryKey(usersId);
        if(users.getPassword().equals(Sha2Util.SHA256(password)))
        {
            users.setPassword(Sha2Util.SHA256(resetPassword));
            if(usersService.updateByPrimaryKeySelective(users)>0)
            {
                msg.put("code","1");
                msg.put("msg","成功");
            }else{
                msg.put("code","0");
                msg.put("msg","失败");
            }
        }else{
            msg.put("code","0");
            msg.put("msg","密码错误");
        }
        return msg;
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Map<String,Object> setUserProfile(@RequestParam("file") MultipartFile profile,HttpServletRequest request){
        msg.clear();
        if(usersService.setUserProfile(profile,request)){
            msg.put("code","1");
            msg.put("msg","成功");
        }else{
            msg.put("code","0");
            msg.put("msg","失败");
        }
        return msg;
    }

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public Map<String,Object> getUserProfile(HttpServletRequest request){
        msg.clear();
        try {
            Long userId = Long.parseLong(request.getAttribute("userId").toString());
            Users users = usersService.selectUserInfo(userId);
            msg.put("code","1");
            msg.put("msg","成功");
            msg.put("url",users.getImage());
        } catch (Exception e) {
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "/balance",method = RequestMethod.POST)
    public Map<String,Object> recharge(@RequestBody Users users,HttpServletRequest request){
        users.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        setMsg(usersService.userRecharge(users),null,null);
        return msg;
    }

    @RequestMapping(value = "/rank",method = RequestMethod.POST)
    public Map<String,Object> rank(@RequestBody Users users){
        List<Users> userList = usersService.rank(users);
        if(userList.size()>0&&userList!=null){
            setMsg(1,null,userList);
        }else{
            setMsg(0,"查询失败",null);
        }
        return msg;
    }
}
