package com.noi.oj.service;

import com.noi.oj.domain.Course;

public interface CourseService {

    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int updateByPrimaryKeySelective(Course record);

}
