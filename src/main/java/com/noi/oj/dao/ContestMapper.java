package com.noi.oj.dao;

import com.noi.oj.domain.*;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ContestMapper {
    long countByExample(ContestExample example);

    int deleteByExample(ContestExample example);

    int deleteByPrimaryKey(Integer contestId);

    int insert(Contest record);

    int insertSelective(Contest record);

    List<Contest> selectByExampleWithBLOBs(ContestExample example);

    List<Contest> selectByExample(ContestExample example);

    Contest selectByPrimaryKey(Integer contestId);

    int updateByExampleSelective(@Param("record") Contest record, @Param("example") ContestExample example);

    int updateByExampleWithBLOBs(@Param("record") Contest record, @Param("example") ContestExample example);

    int updateByExample(@Param("record") Contest record, @Param("example") ContestExample example);

    int updateByPrimaryKeySelective(Contest record);

    int updateByPrimaryKeyWithBLOBs(Contest record);

    int updateByPrimaryKey(Contest record);

    int countUsers(Conditions record);

    int count(Conditions record);

    List<Contest> selectList(Conditions record);

    List<Users> rank(Conditions record);

    Contest selectByUserId(Long userId);

    int selectMaxId();

}