package com.noi.oj.service;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Reply;

import java.util.List;

public interface ReplyService {

    int insert(Reply record);

    int update(Reply record);

    int delete(Integer id);

    List<Reply> select(Conditions record);

}
