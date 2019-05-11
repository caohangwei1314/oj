package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Problem;
import com.noi.oj.domain.ProblemWithBLOBs;
import com.noi.oj.service.ChallengeService;
import com.noi.oj.service.UsersService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/challenge")
public class ChallengeController extends BaseController{

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        Problem problem = challengeService.insert(userId);
        if(problem!=null)
            setMsg(1,null,problem);
        else
            setMsg(0,null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> select(HttpServletRequest request){
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        ProblemWithBLOBs problem = challengeService.select(userId);
        if(problem!=null)
            setMsg(1,null,problem);
        else
            setMsg(0,"暂无挑战",null);
        return msg;
    }

    @RequestMapping(value = "/rank",method = RequestMethod.POST)
    public Map<String,Object> rank(@RequestBody Conditions record){
        PageBean pageBean = usersService.selectChallengeRank(record);
        if(pageBean != null)
            setMsg(1,null,pageBean);
        else
            setMsg(0,"暂无排名",null);
        return msg;
    }
}
