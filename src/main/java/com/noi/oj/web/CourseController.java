package com.noi.oj.web;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Course;
import com.noi.oj.service.CourseService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController{

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody Course record,HttpServletRequest request){
        record.setUserId(Long.parseLong(request.getAttribute("userId").toString()));
        setMsg(courseService.insert(record),null,record.getCourseId());
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Course record){
        setMsg(courseService.updateByPrimaryKeySelective(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id){
        setMsg(courseService.deleteByPrimaryKey(id),null,null);
        return msg;
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Map<String,Object> selectList(@RequestBody Conditions record){
        PageBean pageBean = courseService.selectList(record);
        if(pageBean != null)
            setMsg(1,null,pageBean);
        else
            setMsg(0,null,null);
        return msg;
    }

}
