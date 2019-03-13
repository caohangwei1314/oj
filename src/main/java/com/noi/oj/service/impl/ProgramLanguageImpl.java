package com.noi.oj.service.impl;

import com.noi.oj.dao.ProgramLanguageMapper;
import com.noi.oj.domain.ProgramLanguage;
import com.noi.oj.service.ProgramLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramLanguageImpl implements ProgramLanguageService {

    @Autowired
    private ProgramLanguageMapper programLanguageMapper;

    @Override
    public List<ProgramLanguage> selectAll()
    {
        return programLanguageMapper.selectAll();
    }

    @Override
    public ProgramLanguage selectByPrimaryKey(Integer id)
    {
        return programLanguageMapper.selectByPrimaryKey(id);
    }

}
