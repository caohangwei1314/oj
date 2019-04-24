package com.noi.oj.service;

import com.noi.oj.domain.Tag;

import java.util.List;

public interface TagService {

    int insert(Tag record);

    List<Tag> select();

    int update(Tag record);

    int delete(Integer id);

    List<Tag> statistic(Long userId);

    List<Tag> statisticClass(Long userId);

}
