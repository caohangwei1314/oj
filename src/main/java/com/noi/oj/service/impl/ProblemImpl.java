package com.noi.oj.service.impl;

import com.noi.oj.dao.ProblemMapper;
import com.noi.oj.domain.ProblemWithBLOBs;
import com.noi.oj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public ProblemWithBLOBs selectByPrimaryKey(Integer problemId){
        return problemMapper.selectByPrimaryKey(problemId);
    }
}
