package com.noi.oj.dao;

import com.noi.oj.domain.ProblemClass;
import com.noi.oj.domain.ProblemClassExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProblemClassMapper {
    long countByExample(ProblemClassExample example);

    int deleteByExample(ProblemClassExample example);

    int deleteByPrimaryKey(Integer classId);

    int insert(ProblemClass record);

    int insertSelective(ProblemClass record);

    List<ProblemClass> selectByExample(ProblemClassExample example);

    ProblemClass selectByPrimaryKey(Integer classId);

    int updateByExampleSelective(@Param("record") ProblemClass record, @Param("example") ProblemClassExample example);

    int updateByExample(@Param("record") ProblemClass record, @Param("example") ProblemClassExample example);

    int updateByPrimaryKeySelective(ProblemClass record);

    int updateByPrimaryKey(ProblemClass record);

    int updateByProblemIdSelective(ProblemClass record);

    int deleteByProblemId(Integer ProblemId);

    List<Integer> searchProblemsId(List<Integer> list,Byte difficulty,Byte type);
}