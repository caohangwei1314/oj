package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.ProblemWithBLOBs;
import com.noi.oj.service.ProblemService;
import com.noi.oj.utils.JwtUtil;
import com.noi.oj.utils.PageBean;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("problem")
public class ProblemController extends BaseController{

    @Autowired
    private ProblemService problemService;

    @RequestMapping(method = RequestMethod.POST)
    public BaseController insert(@RequestBody Map<String,Object> problem, HttpServletRequest request){
        try {
            Long userId = Long.parseLong(request.getAttribute("userId").toString());
            return BaseController.result(problemService.insertSelective(problem,userId),null,null);
        }catch (Exception e){
            return BaseController.result(0,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public BaseController select(@RequestParam("id") Integer id){
        try {
            ProblemWithBLOBs problem = problemService.selectByPrimaryKey(id);
            if(problem!=null){
                return BaseController.result(1,null,problem);
            }else{
                return BaseController.result(0,"记录不存在",null);
            }
        }catch (Exception e){
            return BaseController.result(0,e.getMessage(),null);
        }
        
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public BaseController selectList(@RequestBody Conditions record, HttpServletRequest request) {
        String header = request.getHeader("X-Token");
        if(header!=null){
            try {
                JwtUtil jwtUtil = new JwtUtil();
                Claims claims = jwtUtil.parseJWT(header);
                record.setUserId(Long.parseLong(claims.getId()));
            } catch (Exception e) {
                record.setUserId(null);
            }
        }
        PageBean pageBean = problemService.selectList(record);
        if (pageBean != null) {
            return BaseController.result(1, null, pageBean);
        } else {
            return BaseController.result(0, "记录不存在", null);
        }
        
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BaseController update(@RequestBody Map<String,Object> map){
        try {
            return BaseController.result(problemService.updateByPrimaryKeySelective(map),null,null);
        }catch (Exception e){
            return BaseController.result(0,e.getMessage(),null);
        }
        
    }


    @RequestMapping(method = RequestMethod.DELETE)
    public BaseController delete(@RequestParam("id") Integer id){
        try {
            return BaseController.result(problemService.deleteByPrimaryKey(id),null,null);
        }catch (Exception e){
            return BaseController.result(0,e.getMessage(),null);
        }
        
    }

    @RequestMapping(method = RequestMethod.GET)
    public BaseController isBuy(@RequestParam("id") Integer id,HttpServletRequest request){
        try {
            Conditions record = new Conditions();
            record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
            record.setProblemId(id);
            Map<String,Object> map = problemService.isBuy(record);
            return BaseController.result(1,null,map);
        }catch (Exception e){
            return BaseController.result(0,e.getMessage(),null);
        }
        
    }
}
