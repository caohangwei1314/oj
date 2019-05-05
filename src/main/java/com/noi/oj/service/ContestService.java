package com.noi.oj.service;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Contest;
import com.noi.oj.utils.PageBean;

public interface ContestService {

    int insertSelective(Contest record);

    PageBean rank(Conditions record);
}
