package com.noi.oj.dao;

import com.noi.oj.domain.Challenge;
import com.noi.oj.domain.ChallengeExample;
import java.util.List;

import com.noi.oj.domain.Problem;
import com.noi.oj.domain.ProblemWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ChallengeMapper {
    long countByExample(ChallengeExample example);

    int deleteByExample(ChallengeExample example);

    int deleteByPrimaryKey(Integer challengeId);

    int insert(Challenge record);

    int insertSelective(Challenge record);

    List<Challenge> selectByExample(ChallengeExample example);

    Challenge selectByPrimaryKey(Integer challengeId);

    int updateByExampleSelective(@Param("record") Challenge record, @Param("example") ChallengeExample example);

    int updateByExample(@Param("record") Challenge record, @Param("example") ChallengeExample example);

    int updateByPrimaryKeySelective(Challenge record);

    int updateByPrimaryKey(Challenge record);

    ProblemWithBLOBs selectChallenge(Long userId);
}