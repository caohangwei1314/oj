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
    public BaseController insert(@RequestBody Subsection record){
        return BaseController.result(subsectionService.insert(record),null,record.getSubsectionId());
        
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BaseController update(@RequestBody Subsection record){
        return BaseController.result(subsectionService.updateByPrimaryKeySelective(record),null,null);
        
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BaseController delete(@RequestParam("id") Integer id){
        return BaseController.result(subsectionService.deleteByPrimaryKey(id),null,null);
        
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public BaseController selectList(@RequestBody Conditions record){
        List<Subsection> subsectionList = subsectionService.selectByChapterId(record.getChapterId());
        if(subsectionList != null)
            return BaseController.result(1,null,subsectionList);
        else
            return BaseController.result(0,null,null);
        
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public BaseController selectDetail(@RequestParam("id") Integer id){
        Subsection subsection = subsectionService.selectByPrimaryKey(id);
        if(subsection != null)
            return BaseController.result(1,null,subsection);
        else
            return BaseController.result(0,null,null);
        
    }

    @RequestMapping(value = "/temp",method = RequestMethod.POST)
    public BaseController selectDetail(@RequestParam("file") MultipartFile file){
        String url = subsectionService.upload(file);
        if(url != null)
            return BaseController.result(1,null,url);
        else
            return BaseController.result(0,null,null);
        
    }

}
