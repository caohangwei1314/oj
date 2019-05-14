package com.noi.oj.service;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Course;
import com.noi.oj.utils.PageBean;
import org.springframework.web.multipart.MultipartFile;

public interface CourseService {

    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int updateByPrimaryKeySelective(Course record);

    PageBean selectList(Conditions record);

    Course selectAll(Integer id);

    Course selectByPrimaryKey(Integer id);

    String upload(MultipartFile file);
}
