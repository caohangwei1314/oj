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
    public Map<String,Object> insert(@RequestBody Collect record, HttpServletRequest request){
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        setMsg(collectService.insertSelective(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id){
        setMsg(collectService.deleteByPrimaryKey(id),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> select(@RequestBody Conditions conditions,HttpServletRequest request){
        conditions.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        setMsg(1,null,collectService.selectList(conditions));
        return msg;
    }

}
