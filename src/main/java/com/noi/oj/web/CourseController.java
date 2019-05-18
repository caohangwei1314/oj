package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Course;
import com.noi.oj.service.CourseService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController{

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.POST)
    public BaseController insert(@RequestBody Course record,HttpServletRequest request){
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        return BaseController.result(courseService.insert(record),null,record.getCourseId());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BaseController update(@RequestBody Course record){
        return BaseController.result(courseService.updateByPrimaryKeySelective(record),null,null);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BaseController delete(@RequestParam("id") Integer id){
        return BaseController.result(courseService.deleteByPrimaryKey(id),null,null);
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public BaseController selectList(@RequestBody Conditions record){
        PageBean pageBean = courseService.selectList(record);
        if(pageBean != null)
            return BaseController.result(1,null,pageBean);
        else
            return BaseController.result(0,null,null);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public BaseController selectAll(@RequestParam("id") Integer id){
        Course course = courseService.selectAll(id);
        if(course != null)
            return BaseController.result(1,null,course);
        else
            return BaseController.result(0,null,null);
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public BaseController selectDetail(@RequestParam("id") Integer id){
        Course course = courseService.selectByPrimaryKey(id);
        if(course != null)
            return BaseController.result(1,null,course);
        else
            return BaseController.result(0,null,null);
    }

    @RequestMapping(value = "/temp",method = RequestMethod.POST)
    public BaseController selectDetail(@RequestParam("file") MultipartFile file){
        String url = courseService.upload(file);
        if(url != null)
            return BaseController.result(1,null,url);
        else
            return BaseController.result(0,null,null);
    }

}
