package com.noi.oj.service;

import com.noi.oj.domain.Subsection;

import java.util.List;

public interface SubsectionService {

    int deleteByPrimaryKey(Integer subsectionId);

    int insert(Subsection record);

    int updateByPrimaryKeySelective(Subsection record);

    List<Subsection> selectByChapterId(Integer chapterId);
}
