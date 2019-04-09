package com.noi.oj.service.impl;

import com.noi.oj.dao.CollectMapper;
import com.noi.oj.domain.Collect;
import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Problem;
import com.noi.oj.service.CollectService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public int deleteByPrimaryKey(Integer collectId){
        return collectMapper.deleteByPrimaryKey(collectId);
    }

    @Override
    public int insertSelective(Collect record){
        return collectMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Collect record){
        return collectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageBean selectList(Conditions conditions){
        int count = collectMapper.count(conditions);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(conditions.getPage(),count,conditions.getLimit());
        conditions.setOffset(pageBean.getStart());
        List<Problem> collects = collectMapper.selectList(conditions);
        if(collects!=null && collects.size()>0)
            pageBean.setList(collects);
        else
            return null;
        return pageBean;
    }

}
