package com.noi.oj.service;

import com.noi.oj.domain.ProblemWithBLOBs;

public interface ProblemService {
    ProblemWithBLOBs selectByPrimaryKey(Integer problemId);
}
