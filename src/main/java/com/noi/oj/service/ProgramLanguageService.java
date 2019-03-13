package com.noi.oj.service;

import com.noi.oj.domain.ProgramLanguage;

import java.util.List;

public interface ProgramLanguageService {

    ProgramLanguage selectByPrimaryKey(Integer id);

    List<ProgramLanguage> selectAll();

}
