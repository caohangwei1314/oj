package com.noi.oj.service.impl;

import com.noi.oj.dao.ProblemMapper;
import com.noi.oj.domain.Problem;
import com.noi.oj.domain.ProblemWithBLOBs;
import com.noi.oj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProblemImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public ProblemWithBLOBs selectByPrimaryKey(Integer problemId){
        return problemMapper.selectByPrimaryKey(problemId);
    }

    @Override
    public int updateByPrimaryKeySelective(ProblemWithBLOBs record){
        record.setGmtModified(new Date());
        return problemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public boolean updateProblemSubmit(Integer ProblemId){
        ProblemWithBLOBs problem = problemMapper.selectByPrimaryKey(ProblemId);
        if(problem == null){
            return false;
        }
        problem.setSubmit(problem.getSubmit()+1);
        return problemMapper.updateByPrimaryKeySelective(problem)>0;
    }
}
