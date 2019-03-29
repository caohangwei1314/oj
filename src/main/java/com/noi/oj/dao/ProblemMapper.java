package com.noi.oj.dao;

import com.noi.oj.domain.Problem;
import com.noi.oj.domain.ProblemExample;
import com.noi.oj.domain.ProblemWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@Mapper
public interface ProblemMapper {
    long countByExample(ProblemExample example);

    int deleteByExample(ProblemExample example);

    int deleteByPrimaryKey(Integer problemId);

    int insert(ProblemWithBLOBs record);

    int insertSelective(ProblemWithBLOBs record);

    List<ProblemWithBLOBs> selectByExampleWithBLOBs(ProblemExample example);

    List<Problem> selectByExample(ProblemExample example);

    ProblemWithBLOBs selectByPrimaryKey(Integer problemId);

    int updateByExampleSelective(@Param("record") ProblemWithBLOBs record, @Param("example") ProblemExample example);

    int updateByExampleWithBLOBs(@Param("record") ProblemWithBLOBs record, @Param("example") ProblemExample example);

    int updateByExample(@Param("record") Problem record, @Param("example") ProblemExample example);

    int updateByPrimaryKeySelective(ProblemWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProblemWithBLOBs record);

    int updateByPrimaryKey(Problem record);

    int count(List<Integer> list);

    List<Problem> getList(@Param("limit") Integer limit,@Param("offset") Integer offset,String title,List<Integer> list);
}