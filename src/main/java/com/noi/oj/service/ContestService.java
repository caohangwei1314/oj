package com.noi.oj.service;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Contest;
import com.noi.oj.domain.Problem;
import com.noi.oj.domain.Solution;
import com.noi.oj.utils.PageBean;

import java.util.List;

public interface ContestService {

    int insertSelective(Contest record);

    PageBean rank(Conditions record);

    PageBean selectProblem(Conditions record);

    PageBean selectSolution(Conditions record);

    Contest isContest(Long userId);

    PageBean selectList(Conditions record);

    int deleteByContestIdAndUserId(Conditions record);

    Contest selectByPrimaryKey(Integer contestId);

    int updateByPrimaryKeySelective(Contest record);
}
