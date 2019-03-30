package com.noi.oj.service;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.ProblemWithBLOBs;
import com.noi.oj.utils.PageBean;

import java.util.Map;

public interface ProblemService {

    int deleteByPrimaryKey(Integer problemId);

    int insertSelective(Map<String,Object> record,Long userId);

    ProblemWithBLOBs selectByPrimaryKey(Integer problemId);

    PageBean selectList(Conditions record);

    int updateByPrimaryKeySelective(Map<String,Object> map);

}
