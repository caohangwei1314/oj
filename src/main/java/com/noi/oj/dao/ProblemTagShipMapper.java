package com.noi.oj.dao;

import com.noi.oj.domain.ProblemTagShip;
import com.noi.oj.domain.ProblemTagShipExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProblemTagShipMapper {
    long countByExample(ProblemTagShipExample example);

    int deleteByExample(ProblemTagShipExample example);

    int deleteByPrimaryKey(Integer problemTagId);

    int insert(ProblemTagShip record);

    int insertSelective(ProblemTagShip record);

    List<ProblemTagShip> selectByExample(ProblemTagShipExample example);

    ProblemTagShip selectByPrimaryKey(Integer problemTagId);

    int updateByExampleSelective(@Param("record") ProblemTagShip record, @Param("example") ProblemTagShipExample example);

    int updateByExample(@Param("record") ProblemTagShip record, @Param("example") ProblemTagShipExample example);

    int updateByPrimaryKeySelective(ProblemTagShip record);

    int updateByPrimaryKey(ProblemTagShip record);

    int insertList(List<ProblemTagShip> problemTagShips);

    int deleteByProblemId(Integer problemTagId);

    List<Integer> searchProblemsId(List<ProblemTagShip> list);
}