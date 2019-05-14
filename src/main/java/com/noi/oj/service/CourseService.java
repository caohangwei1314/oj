package com.noi.oj.service;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Course;
import com.noi.oj.utils.PageBean;

public interface CourseService {

    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int updateByPrimaryKeySelective(Course record);

    PageBean selectList(Conditions record);
}
