package com.noi.oj.service.impl;

import com.noi.oj.dao.TagMapper;
import com.noi.oj.domain.Tag;
import com.noi.oj.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int insert(Tag record){
        return tagMapper.insertSelective(record);
    }

    @Override
    public List<Tag> select(){
        return tagMapper.selectAll();
    }

    @Override
    public int update(Tag record){
        return tagMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(Integer id){
        return tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Tag> statistic(Long userId){
        return tagMapper.statisticTags(userId);
    }

}
