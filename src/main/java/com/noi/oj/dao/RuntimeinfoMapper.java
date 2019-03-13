package com.noi.oj.dao;

import com.noi.oj.domain.Runtimeinfo;
import com.noi.oj.domain.RuntimeinfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RuntimeinfoMapper {
    long countByExample(RuntimeinfoExample example);

    int deleteByExample(RuntimeinfoExample example);

    int deleteByPrimaryKey(Integer solutionId);

    int insert(Runtimeinfo record);

    int insertSelective(Runtimeinfo record);

    List<Runtimeinfo> selectByExampleWithBLOBs(RuntimeinfoExample example);

    List<Runtimeinfo> selectByExample(RuntimeinfoExample example);

    Runtimeinfo selectByPrimaryKey(Integer solutionId);

    int updateByExampleSelective(@Param("record") Runtimeinfo record, @Param("example") RuntimeinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Runtimeinfo record, @Param("example") RuntimeinfoExample example);

    int updateByExample(@Param("record") Runtimeinfo record, @Param("example") RuntimeinfoExample example);

    int updateByPrimaryKeySelective(Runtimeinfo record);

    int updateByPrimaryKeyWithBLOBs(Runtimeinfo record);

    int updateByPrimaryKey(Runtimeinfo record);
}