package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Subsection;
import com.noi.oj.service.SubsectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
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

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Map<String,Object> selectList(@RequestBody Conditions record){
        List<Subsection> subsectionList = subsectionService.selectByChapterId(record.getChapterId());
        if(subsectionList != null)
            setMsg(1,null,subsectionList);
        else
            setMsg(0,null,null);
        return msg;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Map<String,Object> selectDetail(@RequestParam("id") Integer id){
        Subsection subsection = subsectionService.selectByPrimaryKey(id);
        if(subsection != null)
            setMsg(1,null,subsection);
        else
            setMsg(0,null,null);
        return msg;
    }

    @RequestMapping(value = "/temp",method = RequestMethod.POST)
    public Map<String,Object> selectDetail(@RequestParam("file") MultipartFile file){
        String url = subsectionService.upload(file);
        if(url != null)
            setMsg(1,null,url);
        else
            setMsg(0,null,null);
        return msg;
    }

}
