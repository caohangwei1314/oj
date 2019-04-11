package com.noi.oj.service.impl;

import com.noi.oj.dao.ReplyMapper;
import com.noi.oj.dao.TopicMapper;
import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Topic;
import com.noi.oj.service.TopicService;
import com.noi.oj.service.UsersService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private UsersService usersService;

    @Override
    public int insert(Topic record,Long userId){
        int flag=0;
        record.setAuthorId(userId);
        if(topicMapper.insertSelective(record)>0){
            flag=1;
        }
        return flag;
    }

    @Override
    public int update(Topic record){
        return topicMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(Integer id){
        if(id==null)
            return 0;
        Topic topic = new Topic();
        topic.setTid(id);
        topic.setStatus(1);
        return update(topic);
    }

    @Override
    public PageBean select(Conditions record){
        if(record==null)
            return null;
        int count = topicMapper.count(record.getProblemId());
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit());
        record.setOffset(pageBean.getStart());
        List<Topic> topics = topicMapper.selectList(record);
        if(topics!=null && topics.size()>0){
            for(Topic topic : topics)
                topic.setUsers(usersService.selectUserInfo(topic.getAuthorId()));
            pageBean.setList(topics);
        } else{
            pageBean=null;
        }
        return pageBean;
    }

    @Override
    public Topic selectDetail(Integer id){
        return topicMapper.selectByPrimaryKey(id);
    }

}
