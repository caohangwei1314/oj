package com.noi.oj.web;

import com.noi.oj.domain.Collect;
import com.noi.oj.domain.Conditions;
import com.noi.oj.service.CollectService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("problem/collect")
public class CollectController extends BaseController{

    @Autowired
    private CollectService collectService;

    @RequestMapping(method = RequestMethod.POST)
    public BaseController insert(@RequestBody Collect record, HttpServletRequest request){
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        return BaseController.result(collectService.insertSelective(record),null,null);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BaseController delete(@RequestParam("id") Integer id){
        return BaseController.result(collectService.deleteByPrimaryKey(id),null,null);
    }

    @RequestMapping(method = RequestMethod.GET)
    public BaseController select(@RequestBody Conditions conditions,HttpServletRequest request){
        conditions.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        return BaseController.result(1,null,collectService.selectList(conditions));
    }

}
