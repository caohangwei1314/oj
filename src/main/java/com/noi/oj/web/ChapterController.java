package com.noi.oj.web;

import com.noi.oj.domain.Chapter;
import com.noi.oj.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/chapter")
public class ChapterController extends BaseController{

    @Autowired
    private ChapterService chapterService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody Chapter record){
        setMsg(chapterService.insert(record),null,record.getCourseId());
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Chapter record){
        setMsg(chapterService.updateByPrimaryKeySelective(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id){
        setMsg(chapterService.deleteByPrimaryKey(id),null,null);
        return msg;
    }

}
