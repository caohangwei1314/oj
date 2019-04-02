package com.noi.oj.web;

import com.noi.oj.domain.Solution;
import com.noi.oj.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

}
