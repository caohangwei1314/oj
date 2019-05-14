package com.noi.oj.service;

import com.noi.oj.domain.Chapter;

import java.util.List;

public interface ChapterService {

    int deleteByPrimaryKey(Integer chapterId);

    int insert(Chapter record);

    int updateByPrimaryKeySelective(Chapter record);

    List<Chapter> selectByCourseId(Integer courseId);

    Chapter selectByPrimaryKey(Integer id);

    int countByCourseId(Integer courseId);
}
