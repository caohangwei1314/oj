package com.noi.oj.service;

import com.noi.oj.domain.ProblemWithBLOBs;

public interface ProblemService {

    ProblemWithBLOBs selectByPrimaryKey(Integer problemId);

    int updateByPrimaryKeySelective(ProblemWithBLOBs record);

    boolean updateProblemSubmit(Integer ProblemId);
}
