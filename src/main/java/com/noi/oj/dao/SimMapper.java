package com.noi.oj.dao;

import com.noi.oj.domain.Sim;
import com.noi.oj.domain.SimExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SimMapper {
    long countByExample(SimExample example);

    int deleteByExample(SimExample example);

    int deleteByPrimaryKey(Integer sId);

    int insert(Sim record);

    int insertSelective(Sim record);

    List<Sim> selectByExample(SimExample example);

    Sim selectByPrimaryKey(Integer sId);

    int updateByExampleSelective(@Param("record") Sim record, @Param("example") SimExample example);

    int updateByExample(@Param("record") Sim record, @Param("example") SimExample example);

    int updateByPrimaryKeySelective(Sim record);

    int updateByPrimaryKey(Sim record);
}