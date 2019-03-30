package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.ProblemWithBLOBs;
import com.noi.oj.service.ProblemService;
import com.noi.oj.utils.PageBean;
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
    public Map<String,Object> insert(@RequestBody Map<String,Object> problem, HttpServletRequest request){
        try {
            Long userId = Long.parseLong(request.getAttribute("userId").toString());
            setMsg(problemService.insertSelective(problem,userId),null,null);
        }catch (Exception e){
            setMsg(0,e.getMessage(),null);
        }
        return msg;
    }

    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public Map<String,Object> select(@RequestParam("id") Integer id){
        try {
            ProblemWithBLOBs problem = problemService.selectByPrimaryKey(id);
            if(problem!=null){
                setMsg(1,null,problem);
            }else{
                setMsg(0,"记录不存在",null);
            }
        }catch (Exception e){
            setMsg(0,e.getMessage(),null);
        }
        return msg;
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> selectList(@RequestBody Conditions record) {
        PageBean pageBean = problemService.selectList(record);
        if (pageBean != null) {
            setMsg(1, null, pageBean);
        } else {
            setMsg(0, "记录不存在", null);
        }
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Map<String,Object> map){
        try {
            setMsg(problemService.updateByPrimaryKeySelective(map),null,null);
        }catch (Exception e){
            setMsg(0,e.getMessage(),null);
        }
        return msg;
    }


    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id){
        try {
            setMsg(problemService.deleteByPrimaryKey(id),null,null);
        }catch (Exception e){
            setMsg(0,e.getMessage(),null);
        }
        return msg;
    }
}
