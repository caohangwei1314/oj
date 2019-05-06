package com.noi.oj.service;


import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Solution;
import com.noi.oj.domain.SourceCode;
import com.noi.oj.domain.SubmitMap;
import com.noi.oj.utils.PageBean;

import java.util.List;

public interface SolutionService{

    int insert(Solution record);

    int update(Solution record);

    PageBean selectList(Conditions record);

    List<SubmitMap> submit(Long userId);

    SourceCode selectLoad(Conditions record);
}
