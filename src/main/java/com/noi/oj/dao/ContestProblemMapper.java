package com.noi.oj.dao;

import com.noi.oj.domain.ContestProblem;
import com.noi.oj.domain.ContestProblemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ContestProblemMapper {
    long countByExample(ContestProblemExample example);

    int deleteByExample(ContestProblemExample example);

    int insert(ContestProblem record);

    int insertSelective(ContestProblem record);

    List<ContestProblem> selectByExample(ContestProblemExample example);

    int updateByExampleSelective(@Param("record") ContestProblem record, @Param("example") ContestProblemExample example);

    int updateByExample(@Param("record") ContestProblem record, @Param("example") ContestProblemExample example);
}