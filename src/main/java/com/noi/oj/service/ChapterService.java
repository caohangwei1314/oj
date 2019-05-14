package com.noi.oj.service;

import com.noi.oj.domain.Chapter;

public interface ChapterService {

    int deleteByPrimaryKey(Integer courseId);

    int insert(Chapter record);

    int updateByPrimaryKeySelective(Chapter record);

}
