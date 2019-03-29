package com.noi.oj.dao;

import com.noi.oj.domain.SourceCode;
import com.noi.oj.domain.SourceCodeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SourceCodeMapper {
    long countByExample(SourceCodeExample example);

    int deleteByExample(SourceCodeExample example);

    int deleteByPrimaryKey(Integer solutionId);

    int insert(SourceCode record);

    int insertSelective(SourceCode record);

    List<SourceCode> selectByExampleWithBLOBs(SourceCodeExample example);

    List<SourceCode> selectByExample(SourceCodeExample example);

    SourceCode selectByPrimaryKey(Integer solutionId);

    int updateByExampleSelective(@Param("record") SourceCode record, @Param("example") SourceCodeExample example);

    int updateByExampleWithBLOBs(@Param("record") SourceCode record, @Param("example") SourceCodeExample example);

    int updateByExample(@Param("record") SourceCode record, @Param("example") SourceCodeExample example);

    int updateByPrimaryKeySelective(SourceCode record);

    int updateByPrimaryKeyWithBLOBs(SourceCode record);
}