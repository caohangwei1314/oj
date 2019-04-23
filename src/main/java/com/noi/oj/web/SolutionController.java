package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Solution;
import com.noi.oj.domain.SubmitMap;
import com.noi.oj.service.SolutionService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/solution")
public class SolutionController extends BaseController{

    @Autowired
    private SolutionService solutionService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody Solution record, HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        record.setUserId(userId);
        setMsg(solutionService.insert(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Solution record){
        setMsg(solutionService.update(record),null,null);
        return msg;
    }

    @RequestMapping(value = "/status",method = RequestMethod.POST)
    public Map<String,Object> select(@RequestBody Conditions record, HttpServletRequest request){
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        PageBean pageBean = solutionService.selectList(record);
        if(pageBean!=null)
            setMsg(1,null,pageBean);
        else
            setMsg(0,null,null);
        return msg;
    }

    @RequestMapping(value = "/submit",method = RequestMethod.GET)
    public Map<String,Object> submit(HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        List<SubmitMap> submitMaps = solutionService.submit(userId);
        if(submitMaps.size()>0&&submitMaps!=null)
            setMsg(1,null,submitMaps);
        else
            setMsg(0,"暂无提交",null);
        return msg;
    }
}
