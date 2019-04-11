package com.noi.oj.service;


import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Solution;
import com.noi.oj.utils.PageBean;

public interface SolutionService{

    int insert(Solution record);

    int update(Solution record);

    PageBean selectList(Conditions record);

}
