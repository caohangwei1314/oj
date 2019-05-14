package com.noi.oj.web;

import com.noi.oj.domain.Chapter;
import com.noi.oj.domain.Conditions;
import com.noi.oj.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("chapter")
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

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Map<String,Object> selectList(@RequestBody Conditions record){
        List<Chapter> chapterList = chapterService.selectByCourseId(record.getCourseId());
        if(chapterList != null)
            setMsg(1,null,chapterList);
        else
            setMsg(0,"暂无章节",null);
        return msg;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Map<String,Object> selectDetail(@RequestParam("id") Integer id){
        Chapter chapter = chapterService.selectByPrimaryKey(id);
        if(chapter != null)
            setMsg(1,null,chapter);
        else
            setMsg(0,null,null);
        return msg;
    }

}
