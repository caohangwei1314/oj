package com.noi.oj.service;

import com.noi.oj.domain.Compileinfo;
import com.noi.oj.domain.Runtimeinfo;
import com.noi.oj.domain.Solution;

public interface SolutionService {

    int insertSelective(Solution record);

    Solution selectByPrimaryKey(Integer solutionId);

    Solution selectByPid(Long userId,Integer Pid);

    int updateByPrimaryKeySelective(Solution record);

    int updateCompileError(Compileinfo record);

    int updateRunError(Runtimeinfo record);

}
