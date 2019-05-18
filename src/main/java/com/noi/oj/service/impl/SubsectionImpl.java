package com.noi.oj.service.impl;

import com.noi.oj.dao.SubsectionMapper;
import com.noi.oj.domain.Subsection;
import com.noi.oj.service.SubsectionService;
import com.noi.oj.utils.SystemConstant;
import com.noi.oj.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.Subject;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SubsectionImpl implements SubsectionService {

    private static final String NAME="subsection";

    @Autowired
    private SubsectionMapper subsectionMapper;

    @Override
    public int deleteByPrimaryKey(Integer subsectionId){
        return subsectionMapper.deleteByPrimaryKey(subsectionId);
    }

    @Override
    public int insert(Subsection record){
        if(record.getUrl()!=null){
            String[] origin = record.getUrl().split("/");
            record.setUrl(origin[origin.length-1]);
        }
        Date date = new Date();
        record.setGmtCreate(date);
        record.setGmtModified(date);
        return subsectionMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Subsection record){
        record.setGmtModified(new Date());
        if(record.getUrl()!=null){
            String[] origin = record.getUrl().split("/");
            record.setUrl(origin[origin.length-1]);
        }
        return subsectionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Subsection> selectByChapterId(Integer chapterId){
        List<Subsection> subsectionList = subsectionMapper.selectByChapterId(chapterId);
        for(Subsection subsection : subsectionList)
            if(subsection.getUrl()!=null)
                subsection.setUrl(UploadUtils.getUrl(subsection.getUrl(),NAME));
        return subsectionList;
    }

    @Override
    public Subsection selectByPrimaryKey(Integer id){
        Subsection subsection = subsectionMapper.selectByPrimaryKey(id);
        if(subsection.getUrl()!=null)
            subsection.setUrl(UploadUtils.getUrl(subsection.getUrl(),NAME));
        return subsection;
    }

    @Override
    public String upload(MultipartFile file){
        String[] originName = file.getOriginalFilename().split("\\.");
        String suffix = originName[originName.length-1];
        String name = UUID.randomUUID().toString() + "." + suffix;
        if(UploadUtils.setProductProfile(file,name, SystemConstant.LINUX_SUBSECTION_PATH)){
            return UploadUtils.getUrl(name,NAME);
        }else{
            return null;
        }
    }

    @Override
    public int countByCourseId(Integer courseId){
        return subsectionMapper.countByCourseId(courseId);
    }

}
