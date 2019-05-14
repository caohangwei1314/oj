package com.noi.oj.service.impl;

import com.noi.oj.dao.ChapterMapper;
import com.noi.oj.dao.CourseMapper;
import com.noi.oj.dao.SubsectionMapper;
import com.noi.oj.dao.UsersMapper;
import com.noi.oj.domain.Chapter;
import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Course;
import com.noi.oj.service.ChapterService;
import com.noi.oj.service.CourseService;
import com.noi.oj.service.SubsectionService;
import com.noi.oj.utils.PageBean;
import com.noi.oj.utils.SystemConstant;
import com.noi.oj.utils.UploadUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

@Service
public class CourseImpl implements CourseService {

    private static final String NAME = "course";

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private SubsectionService subsectionService;

    @Override
    public int deleteByPrimaryKey(Integer courseId){
        Course course = new Course();
        course.setState(-1);
        course.setCourseId(courseId);
        return updateByPrimaryKeySelective(course);
    }

    @Override
    public int insert(Course record){
        Date date = new Date();
        record.setGmtCreate(date);
        record.setGmtModified(date);
        if(record.getImage()!=null){
            String[] orginName = record.getImage().split("/");
            record.setImage(orginName[orginName.length-1]);
        }
        return courseMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record){
        record.setGmtModified(new Date());
        if(record.getImage()!=null){
            String[] orginName = record.getImage().split("/");
            record.setImage(orginName[orginName.length-1]);
        }
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageBean selectList(Conditions record){
        int count = courseMapper.count(record);
        if(count < 1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit());
        record.setOffset(pageBean.getStart());
        pageBean.setList(courseMapper.selectList(record));
        return pageBean;
    }

    @Override
    public Course selectAll(Integer id){
        Course course = courseMapper.selectByPrimaryKey(id);
        course.setUsers(usersMapper.selectByPrimaryKey(course.getUserId()));
        course.setChapterList(chapterService.selectByCourseId(course.getCourseId()));
        for(Chapter chapter : course.getChapterList())
            chapter.setSubsectionList(subsectionService.selectByChapterId(chapter.getChapterId()));
        return course;
    }

    @Override
    public Course selectByPrimaryKey(Integer id){
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public String upload(MultipartFile file){
        String[] originName = file.getOriginalFilename().split("\\.");
        String suffix = originName[originName.length-1];
        String name = UUID.randomUUID().toString() + "." + suffix;
        if(UploadUtils.setProductProfile(file,name, SystemConstant.WINDOWS_COURSE_PATH)){
            return UploadUtils.getUrl(name,NAME);
        }else{
            return null;
        }
    }

}
