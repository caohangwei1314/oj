package com.noi.oj.service.impl;

import com.noi.oj.dao.SubsectionMapper;
import com.noi.oj.domain.Subsection;
import com.noi.oj.service.SubsectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubsectionImpl implements SubsectionService {

    @Autowired
    private SubsectionMapper subsectionMapper;

    @Override
    public int deleteByPrimaryKey(Integer subsectionId){
        return subsectionMapper.deleteByPrimaryKey(subsectionId);
    }

    @Override
    public int insert(Subsection record){
        Date date = new Date();
        record.setGmtCreate(date);
        record.setGmtModified(date);
        return subsectionMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Subsection record){
        record.setGmtModified(new Date());
        return subsectionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Subsection> selectByChapterId(Integer chapterId){
        return subsectionMapper.selectByChapterId(chapterId);
    }

    @Override
    public Subsection selectByPrimaryKey(Integer id){
        return subsectionMapper.selectByPrimaryKey(id);
    }

}
