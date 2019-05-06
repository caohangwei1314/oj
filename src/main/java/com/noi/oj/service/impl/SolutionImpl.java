package com.noi.oj.service.impl;

import com.noi.oj.config.ServerConfig;
import com.noi.oj.dao.ProblemMapper;
import com.noi.oj.dao.SolutionMapper;
import com.noi.oj.dao.SourceCodeMapper;
import com.noi.oj.dao.SourceCodeUserMapper;
import com.noi.oj.domain.*;
import com.noi.oj.service.ProblemService;
import com.noi.oj.service.SolutionService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionImpl implements SolutionService {

    @Autowired
    private SolutionMapper solutionMapper;

    @Autowired
    private SourceCodeMapper sourceCodeMapper;

    @Autowired
    private SourceCodeUserMapper sourceCodeUserMapper;

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public int insert(Solution record) {
        int flag=0;
        if(record==null || record.getSource()==null)
            return flag;
        ServerConfig serverConfig = new ServerConfig();
        record.setIp(serverConfig.getHost());
        record.setCodeLength(record.getSource().length());
        if(solutionMapper.insertSelective(record)>0){
            if(insertSourceCode(record)>0){
                ProblemWithBLOBs problem = problemMapper.selectByPrimaryKey(record.getProblemId());
                problem.setSubmit(problem.getSubmit()+1);
                flag = problemMapper.updateByPrimaryKeySelective(problem);
            }
        }
        return flag;
    }

    @Override
    public int update(Solution record){
        int flag=0;
        if(record==null)
            return flag;
        if(solutionMapper.updateByPrimaryKeySelective(record)>0)
            if(record.getSource()!=null)
                flag = updateSourceCode(record);
        return flag;
    }

    @Override
    public PageBean selectList(Conditions record){
        int count = solutionMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit());
        record.setOffset(pageBean.getStart());
        List<Solution> solutions = solutionMapper.selectList(record);
        if(solutions==null || solutions.size()<1)
            return null;
        pageBean.setList(solutions);
        return pageBean;
    }

    @Override
    public List<SubmitMap> submit(Long userId){
        return solutionMapper.submit(userId);
    }

    @Override
    public SourceCode selectLoad(Conditions record){
        return sourceCodeMapper.selectLoad(record);
    }

    private int insertSourceCode(Solution record){
        int flag=0;
        SourceCode sourceCode = newSourceCode(record);
        SourceCodeUser sourceCodeUser = newSourceCodeUser(record);
        if(sourceCodeMapper.insertSelective(sourceCode)>0 && sourceCodeUserMapper.insertSelective(sourceCodeUser)>0)
            flag=1;
        return flag;
    }

    private int updateSourceCode(Solution record){
        int flag=0;
        SourceCode sourceCode = newSourceCode(record);
        SourceCodeUser sourceCodeUser = newSourceCodeUser(record);
        if(sourceCodeMapper.updateByPrimaryKeyWithBLOBs(sourceCode)>0 && sourceCodeUserMapper.updateByPrimaryKeyWithBLOBs(sourceCodeUser)>0)
            flag=1;
        return flag;
    }

    private SourceCode newSourceCode(Solution record){
        SourceCode sourceCode = new SourceCode();
        sourceCode.setSolutionId(record.getSolutionId());
        sourceCode.setSource(record.getSource());
        return sourceCode;
    }

    private SourceCodeUser newSourceCodeUser(Solution record){
        SourceCodeUser sourceCodeUser = new SourceCodeUser();
        sourceCodeUser.setSolutionId(record.getSolutionId());
        sourceCodeUser.setSource(record.getSource());
        return sourceCodeUser;
    }
}
