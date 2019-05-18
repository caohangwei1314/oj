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
    public BaseController insert(@RequestBody Chapter record){
        return BaseController.result(chapterService.insert(record),null,record.getCourseId());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BaseController update(@RequestBody Chapter record){
        return BaseController.result(chapterService.updateByPrimaryKeySelective(record),null,null);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BaseController delete(@RequestParam("id") Integer id){
        return BaseController.result(chapterService.deleteByPrimaryKey(id),null,null);
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public BaseController selectList(@RequestBody Conditions record){
        List<Chapter> chapterList = chapterService.selectByCourseId(record.getCourseId());
        if(chapterList != null)
            return BaseController.result(1,null,chapterList);
        else
            return BaseController.result(0,"暂无章节",null);
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public BaseController selectDetail(@RequestParam("id") Integer id){
        Chapter chapter = chapterService.selectByPrimaryKey(id);
        if(chapter != null)
            return BaseController.result(1,null,chapter);
        else
            return BaseController.result(0,null,null);
    }

}
