package com.noi.oj.web;

import com.noi.oj.domain.Subsection;
import com.noi.oj.service.SubsectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/subsection")
public class SubsectionController extends BaseController{

    @Autowired
    private SubsectionService subsectionService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody Subsection record){
        setMsg(subsectionService.insert(record),null,record.getSubsectionId());
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Subsection record){
        setMsg(subsectionService.updateByPrimaryKeySelective(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id){
        setMsg(subsectionService.deleteByPrimaryKey(id),null,null);
        return msg;
    }

}
