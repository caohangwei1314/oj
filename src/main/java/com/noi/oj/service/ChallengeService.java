package com.noi.oj.service;

import com.noi.oj.domain.Problem;
import com.noi.oj.domain.ProblemWithBLOBs;

public interface ChallengeService {

    Problem insert(Long userId);

    ProblemWithBLOBs select(Long userId);
}
