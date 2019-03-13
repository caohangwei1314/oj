package com.noi.oj.web;

import com.noi.oj.domain.Solution;
import com.noi.oj.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("users/solution")
public class SolutionController extends BaseController{

    @Autowired
    private SolutionService solutionService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody Solution solution, HttpServletRequest request){
        msg.clear();
        try {
            Long userId = Long.parseLong(request.getAttribute("userId").toString());
            solution.setUserId(userId);
            if(solutionService.insertSelective(solution)>0){
                msg.put("code","1");
                msg.put("msg","成功");
            }else{
                msg.put("code","0");
                msg.put("msg","失败");
            }
        } catch (NumberFormatException e) {
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Map<String,Object> select(@PathVariable("id") Integer id, HttpServletRequest request){
        msg.clear();
        try {
            Long userId = Long.parseLong(request.getAttribute("userId").toString());
            if(solutionService.selectByPid(userId,id)!=null){
                msg.put("code","1");
                msg.put("msg","成功");
            }else{
                msg.put("code","0");
                msg.put("msg","失败");
            }
        } catch (NumberFormatException e) {
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Solution solution){
        msg.clear();
        try {
            if(solutionService.updateByPrimaryKeySelective(solution)>0){
                msg.put("code","1");
                msg.put("msg","成功");
            }else{
                msg.put("code","0");
                msg.put("msg","失败");
            }
        } catch (NumberFormatException e) {
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }
}
