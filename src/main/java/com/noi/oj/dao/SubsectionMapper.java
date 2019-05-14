package com.noi.oj.dao;

import com.noi.oj.domain.Chapter;
import com.noi.oj.domain.Subsection;
import com.noi.oj.domain.SubsectionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SubsectionMapper {
    long countByExample(SubsectionExample example);

    int deleteByExample(SubsectionExample example);

    int deleteByPrimaryKey(Integer subsectionId);

    int insert(Subsection record);

    int insertSelective(Subsection record);

    List<Subsection> selectByExample(SubsectionExample example);

    Subsection selectByPrimaryKey(Integer subsectionId);

    int updateByExampleSelective(@Param("record") Subsection record, @Param("example") SubsectionExample example);

    int updateByExample(@Param("record") Subsection record, @Param("example") SubsectionExample example);

    int updateByPrimaryKeySelective(Subsection record);

    int updateByPrimaryKey(Subsection record);

    List<Subsection> selectByChapterId(Integer chapterId);
}