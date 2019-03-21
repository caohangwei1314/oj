package com.noi.oj.service.impl;

import com.noi.oj.core.judge.JudgeService;
import com.noi.oj.dao.*;
import com.noi.oj.domain.*;
import com.noi.oj.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SolutionImpl implements SolutionService {

    @Autowired
    private SolutionMapper solutionMapper;

    @Autowired
    private CompileinfoMapper compileinfoMapper;

    @Autowired
    private RuntimeinfoMapper runtimeinfoMapper;

    @Autowired
    private SourceCodeMapper sourceCodeMapper;

    private static final JudgeService judgeService = JudgeService.me();

    @Override
    public int insertSelective(Solution record){
        if(solutionMapper.insertSelective(record)>0){
            SourceCode code = new SourceCode();
            Date date = new Date();
            code.setSolutionId(record.getSolutionId());
            code.setSource(record.getCode());
            code.setGmtCreate(date);
            code.setGmtModified(date);
             if(sourceCodeMapper.insert(code)>0){
                 judgeService.judge(record);
             }else{
                 return -2;
             }
        }else{
            return -2;
        }
        return 1;
    }

    @Override
    public Solution selectByPrimaryKey(Integer solutionId){
        return solutionMapper.selectByPrimaryKey(solutionId);
    }

    @Override
    public Solution selectByPid(Long userId,Integer Pid){
        SolutionExample example = new SolutionExample();
        SolutionExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andProblemIdEqualTo(Pid);
        List<Solution> solutions = solutionMapper.selectByExample(example);
        if(solutions.size()>0&&solutions!=null) {
            return solutions.get(0);
        }else{
            return null;
        }
    }

    @Override
    public int updateByPrimaryKeySelective(Solution record){
        return solutionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateCompileError(Compileinfo record)
    {
        CompileinfoExample example = new CompileinfoExample();
        CompileinfoExample.Criteria criteria = example.createCriteria();
        criteria.andSolutionIdEqualTo(record.getSolutionId());
        if(compileinfoMapper.countByExample(example)>0){
            return compileinfoMapper.updateByExampleSelective(record,example);
        }else{
            Date date = new Date();
            record.setGmtCreate(date);
            record.setGmtModified(date);
            return compileinfoMapper.insert(record);
        }
    }

    @Override
    public int updateRunError(Runtimeinfo record){
        RuntimeinfoExample example = new RuntimeinfoExample();
        RuntimeinfoExample.Criteria criteria = example.createCriteria();
        criteria.andSolutionIdEqualTo(record.getSolutionId());
        if(runtimeinfoMapper.countByExample(example)>0){
            return runtimeinfoMapper.updateByExampleSelective(record,example);
        }else{
            Date date = new Date();
            record.setGmtCreate(date);
            record.setGmtModified(date);
            return runtimeinfoMapper.insert(record);
        }
    }

    @Override
    public long countAccess(Long userId){
        SolutionExample example = new SolutionExample();
        SolutionExample.Criteria criteria = example.createCriteria();
        if(userId!=null){
            criteria.andUserIdEqualTo(userId);
        }
        criteria.andResultEqualTo(ResultType.AC);
        return solutionMapper.countByExample(example);
    }
}
