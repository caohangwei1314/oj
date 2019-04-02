package com.noi.oj.service.impl;

import com.noi.oj.config.ServerConfig;
import com.noi.oj.dao.SolutionMapper;
import com.noi.oj.dao.SourceCodeMapper;
import com.noi.oj.dao.SourceCodeUserMapper;
import com.noi.oj.domain.Solution;
import com.noi.oj.domain.SourceCode;
import com.noi.oj.domain.SourceCodeUser;
import com.noi.oj.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolutionImpl implements SolutionService {

    @Autowired
    private SolutionMapper solutionMapper;

    @Autowired
    private SourceCodeMapper sourceCodeMapper;

    @Autowired
    private SourceCodeUserMapper sourceCodeUserMapper;


    @Override
    public int insert(Solution record) {
        int flag=0;
        if(record==null || record.getSource()==null)
            return flag;
        ServerConfig serverConfig = new ServerConfig();
        record.setIp(serverConfig.getHost());
        record.setCodeLength(record.getSource().length());
        if(solutionMapper.insertSelective(record)>0){
            flag = insertSourceCode(record);
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
