package com.noi.oj.service.impl;

import com.noi.oj.dao.CompileinfoMapper;
import com.noi.oj.dao.RuntimeinfoMapper;
import com.noi.oj.dao.SolutionMapper;
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

    @Override
    public int insertSelective(Solution record){
        return solutionMapper.insertSelective(record);
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
}
