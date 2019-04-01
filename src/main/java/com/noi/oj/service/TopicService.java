package com.noi.oj.service;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Topic;
import com.noi.oj.utils.PageBean;

public interface TopicService {

    int insert(Topic record,Long userId);

    int update(Topic record);

    int delete(Integer id);

    PageBean select(Conditions record);

    Topic selectDetail(Integer id);
}
