package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Problem;
import com.noi.oj.domain.ProblemWithBLOBs;
import com.noi.oj.service.ChallengeService;
import com.noi.oj.service.SolutionService;
import com.noi.oj.service.UsersService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/challenge")
public class ChallengeController{

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private SolutionService solutionService;

    @RequestMapping(method = RequestMethod.POST)
    public BaseController insert(HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        Problem problem = challengeService.insert(userId);
        if(problem!=null)
            return BaseController.result(1,null,problem);
        else
            return BaseController.result(0,null,null);
    }

    @RequestMapping(method = RequestMethod.GET)
    public BaseController select(HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        ProblemWithBLOBs problem = challengeService.select(userId);
        if(problem!=null)
            return BaseController.result(1,null,problem);
        else
            return BaseController.result(0,"暂无挑战",null);
    }

    @RequestMapping(value = "/rank",method = RequestMethod.POST)
    public BaseController rank(@RequestBody Conditions record){
        PageBean pageBean = usersService.selectChallengeRank(record);
        if(pageBean != null)
            return BaseController.result(1,null,pageBean);
        else
            return BaseController.result(0,"暂无排名",null);
    }

    @RequestMapping(value = "/solution",method = RequestMethod.POST)
    public BaseController selectSolution(@RequestBody Conditions conditions,HttpServletRequest request){
        conditions.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        return BaseController.result(1,null,solutionService.selectList(conditions));
    }
}
