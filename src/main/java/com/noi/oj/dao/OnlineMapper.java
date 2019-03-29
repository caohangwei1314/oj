package com.noi.oj.dao;

import com.noi.oj.domain.Online;
import com.noi.oj.domain.OnlineExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OnlineMapper {
    long countByExample(OnlineExample example);

    int deleteByExample(OnlineExample example);

    int deleteByPrimaryKey(String hash);

    int insert(Online record);

    int insertSelective(Online record);

    List<Online> selectByExample(OnlineExample example);

    Online selectByPrimaryKey(String hash);

    int updateByExampleSelective(@Param("record") Online record, @Param("example") OnlineExample example);

    int updateByExample(@Param("record") Online record, @Param("example") OnlineExample example);

    int updateByPrimaryKeySelective(Online record);

    int updateByPrimaryKey(Online record);
}