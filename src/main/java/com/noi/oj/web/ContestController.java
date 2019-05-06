package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Contest;
import com.noi.oj.domain.Problem;
import com.noi.oj.domain.Solution;
import com.noi.oj.service.ContestService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contest")
public class ContestController extends BaseController{

    @Autowired
    private ContestService contestService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody Contest record, HttpServletRequest request){
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        setMsg(contestService.insertSelective(record),null,record.getContestId());
        return msg;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> detail(@RequestParam("id") Integer id, HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        Conditions record = new Conditions();
        record.setUserId(userId);
        record.setContestId(id);
        List<Problem> problems = contestService.selectProblem(record);
        if(problems!=null)
            setMsg(1,null,problems);
        else
            setMsg(0,null,null);
        return msg;
    }

    @RequestMapping(value = "/solution",method = RequestMethod.POST)
    public Map<String,Object> solution(@RequestBody Conditions record, HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        record.setUserId(userId);
        PageBean solutions = contestService.selectSolution(record);
        if(solutions!=null)
            setMsg(1,null,solutions);
        else
            setMsg(0,"暂无记录",null);
        return msg;
    }

    @RequestMapping(value = "/rank",method = RequestMethod.POST)
    public Map<String,Object> rank(@RequestBody Conditions record){
        setMsg(1,null,contestService.rank(record));
        return msg;
    }

    @RequestMapping(value = "/status",method = RequestMethod.GET)
    public Map<String,Object> rank(HttpServletRequest request){
        Contest contest = contestService.isContest(Long.parseLong(request.getAttribute("userId").toString()));
        if(contest != null)
            setMsg(1,null,contest);
        else
            setMsg(0,null,null);
        return msg;
    }

}
