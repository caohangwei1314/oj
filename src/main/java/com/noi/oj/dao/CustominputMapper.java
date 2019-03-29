package com.noi.oj.dao;

import com.noi.oj.domain.Custominput;
import com.noi.oj.domain.CustominputExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustominputMapper {
    long countByExample(CustominputExample example);

    int deleteByExample(CustominputExample example);

    int deleteByPrimaryKey(Integer solutionId);

    int insert(Custominput record);

    int insertSelective(Custominput record);

    List<Custominput> selectByExampleWithBLOBs(CustominputExample example);

    List<Custominput> selectByExample(CustominputExample example);

    Custominput selectByPrimaryKey(Integer solutionId);

    int updateByExampleSelective(@Param("record") Custominput record, @Param("example") CustominputExample example);

    int updateByExampleWithBLOBs(@Param("record") Custominput record, @Param("example") CustominputExample example);

    int updateByExample(@Param("record") Custominput record, @Param("example") CustominputExample example);

    int updateByPrimaryKeySelective(Custominput record);

    int updateByPrimaryKeyWithBLOBs(Custominput record);
}