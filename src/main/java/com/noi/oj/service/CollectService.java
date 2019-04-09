package com.noi.oj.service;

import com.noi.oj.domain.Collect;
import com.noi.oj.domain.Conditions;
import com.noi.oj.utils.PageBean;

public interface CollectService {

    int deleteByPrimaryKey(Integer collectId);

    int insertSelective(Collect record);

    int updateByPrimaryKeySelective(Collect record);

    PageBean selectList(Conditions conditions);
}
