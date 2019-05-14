package com.noi.oj.service.impl;

import com.noi.oj.dao.ChapterMapper;
import com.noi.oj.dao.SubsectionMapper;
import com.noi.oj.domain.Chapter;
import com.noi.oj.service.ChapterService;
import com.noi.oj.service.SubsectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChapterImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private SubsectionService subsectionService;

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

    @Override
    public List<Chapter> selectByCourseId(Integer courseId){
        List<Chapter> chapterList = chapterMapper.selectByCourseId(courseId);
        return chapterList;
    }

    @Override
    public Chapter selectByPrimaryKey(Integer id){
        return chapterMapper.selectByPrimaryKey(id);
    }

}
