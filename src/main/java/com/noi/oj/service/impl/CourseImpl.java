package com.noi.oj.service.impl;

import com.noi.oj.dao.CourseMapper;
import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Course;
import com.noi.oj.service.CourseService;
import com.noi.oj.utils.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CourseImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int deleteByPrimaryKey(Integer courseId){
        Course course = new Course();
        course.setState(-1);
        course.setCourseId(courseId);
        return updateByPrimaryKeySelective(course);
    }

    @Override
    public int insert(Course record){
        Date date = new Date();
        record.setGmtCreate(date);
        record.setGmtModified(date);
        return courseMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record){
        record.setGmtModified(new Date());
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageBean selectList(Conditions record){
        int count = courseMapper.count(record);
        if(count < 1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit());
        record.setOffset(pageBean.getStart());
        pageBean.setList(courseMapper.selectList(record));
        return pageBean;
    }

}
