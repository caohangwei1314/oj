package com.noi.oj.dao;

import com.noi.oj.domain.ProgramLanguage;
import com.noi.oj.domain.ProgramLanguageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProgramLanguageMapper {
    long countByExample(ProgramLanguageExample example);

    int deleteByExample(ProgramLanguageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProgramLanguage record);

    int insertSelective(ProgramLanguage record);

    List<ProgramLanguage> selectByExample(ProgramLanguageExample example);

    ProgramLanguage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProgramLanguage record, @Param("example") ProgramLanguageExample example);

    int updateByExample(@Param("record") ProgramLanguage record, @Param("example") ProgramLanguageExample example);

    int updateByPrimaryKeySelective(ProgramLanguage record);

    int updateByPrimaryKey(ProgramLanguage record);

    List<ProgramLanguage> selectAll();
}