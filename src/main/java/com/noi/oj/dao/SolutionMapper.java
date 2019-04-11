package com.noi.oj.dao;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Solution;
import com.noi.oj.domain.SolutionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SolutionMapper {
    long countByExample(SolutionExample example);

    int deleteByExample(SolutionExample example);

    int deleteByPrimaryKey(Integer solutionId);

    int insert(Solution record);

    int insertSelective(Solution record);

    List<Solution> selectByExample(SolutionExample example);

    Solution selectByPrimaryKey(Integer solutionId);

    int updateByExampleSelective(@Param("record") Solution record, @Param("example") SolutionExample example);

    int updateByExample(@Param("record") Solution record, @Param("example") SolutionExample example);

    int updateByPrimaryKeySelective(Solution record);

    int updateByPrimaryKey(Solution record);

    int count(Conditions record);

    List<Solution> selectList(Conditions record);
}