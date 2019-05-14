package com.noi.oj.service.impl;

import com.noi.oj.dao.ChapterMapper;
import com.noi.oj.domain.Chapter;
import com.noi.oj.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChapterImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public int deleteByPrimaryKey(Integer chapterId){
        return chapterMapper.deleteByPrimaryKey(chapterId);
    }

    @Override
    public int insert(Chapter record){
        Date date = new Date();
        record.setGmtCreate(date);
        record.setGmtModified(date);
        return chapterMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Chapter record){
        record.setGmtModified(new Date());
        return chapterMapper.updateByPrimaryKeySelective(record);
    }

}
