package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Contest;
import com.noi.oj.service.ContestService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/contest")
public class ContestController extends BaseController{

    @Autowired
    private ContestService contestService;

    @RequestMapping(method = RequestMethod.POST)
    public BaseController insert(HttpServletRequest request){
        Contest record = new Contest();
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        return BaseController.result(contestService.insertSelective(record),null,record.getContestId());
    }

    @RequestMapping(method = RequestMethod.GET)
    public BaseController detail(@RequestParam("id") Integer id, HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        Conditions record = new Conditions();
        record.setUserId(userId);
        record.setContestId(id);
        PageBean problems = contestService.selectProblem(record);
        if(problems!=null)
            return BaseController.result(1,null,problems);
        else
            return BaseController.result(0,null,null);
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public BaseController ContestDetail(@RequestParam("id") Integer id){
        Conditions record = new Conditions();
        record.setContestId(id);
        Contest contest = contestService.selectByPrimaryKey(id);
        if(contest!=null)
            return BaseController.result(1,null,contest);
        else
            return BaseController.result(0,null,null);
    }

    @RequestMapping(value = "/record",method = RequestMethod.POST)
    public BaseController list(@RequestBody Conditions record, HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        record.setUserId(userId);
        PageBean problems = contestService.selectList(record);
        if(problems!=null)
            return BaseController.result(1,null,problems);
        else
            return BaseController.result(0,null,null);
    }

    @RequestMapping(value = "/solution",method = RequestMethod.POST)
    public BaseController solution(@RequestBody Conditions record, HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        record.setUserId(userId);
        PageBean solutions = contestService.selectSolution(record);
        if(solutions!=null)
            return BaseController.result(1,null,solutions);
        else
            return BaseController.result(0,"暂无记录",null);
    }

    @RequestMapping(value = "/rank",method = RequestMethod.POST)
    public BaseController rank(@RequestBody Conditions record){
        return BaseController.result(1,null,contestService.rank(record));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BaseController update(@RequestBody Contest record){
        return BaseController.result(contestService.updateByPrimaryKeySelective(record),null,null);
    }

    @RequestMapping(value = "/status",method = RequestMethod.GET)
    public BaseController rank(HttpServletRequest request){
        Contest contest = contestService.isContest(Long.parseLong(request.getAttribute("userId").toString()));
        if(contest != null)
            return BaseController.result(1,null,contest);
        else
            return BaseController.result(0,null,null);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BaseController delete(@RequestParam("id") Integer id,HttpServletRequest request){
        Conditions record = new Conditions();
        record.setContestId(id);
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        return BaseController.result(contestService.deleteByContestIdAndUserId(record),null,null);
    }
}
