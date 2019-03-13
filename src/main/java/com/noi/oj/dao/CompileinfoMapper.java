package com.noi.oj.dao;

import com.noi.oj.domain.Compileinfo;
import com.noi.oj.domain.CompileinfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CompileinfoMapper {
    long countByExample(CompileinfoExample example);

    int deleteByExample(CompileinfoExample example);

    int deleteByPrimaryKey(Integer solutionId);

    int insert(Compileinfo record);

    int insertSelective(Compileinfo record);

    List<Compileinfo> selectByExampleWithBLOBs(CompileinfoExample example);

    List<Compileinfo> selectByExample(CompileinfoExample example);

    Compileinfo selectByPrimaryKey(Integer solutionId);

    int updateByExampleSelective(@Param("record") Compileinfo record, @Param("example") CompileinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Compileinfo record, @Param("example") CompileinfoExample example);

    int updateByExample(@Param("record") Compileinfo record, @Param("example") CompileinfoExample example);

    int updateByPrimaryKeySelective(Compileinfo record);

    int updateByPrimaryKeyWithBLOBs(Compileinfo record);

    int updateByPrimaryKey(Compileinfo record);
}