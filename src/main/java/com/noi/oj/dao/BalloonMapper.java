package com.noi.oj.dao;

import com.noi.oj.domain.Balloon;
import com.noi.oj.domain.BalloonExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BalloonMapper {
    long countByExample(BalloonExample example);

    int deleteByExample(BalloonExample example);

    int deleteByPrimaryKey(Integer balloonId);

    int insert(Balloon record);

    int insertSelective(Balloon record);

    List<Balloon> selectByExample(BalloonExample example);

    Balloon selectByPrimaryKey(Integer balloonId);

    int updateByExampleSelective(@Param("record") Balloon record, @Param("example") BalloonExample example);

    int updateByExample(@Param("record") Balloon record, @Param("example") BalloonExample example);

    int updateByPrimaryKeySelective(Balloon record);

    int updateByPrimaryKey(Balloon record);
}