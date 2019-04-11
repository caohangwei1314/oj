package com.noi.oj.service.impl;

import com.noi.oj.dao.ReplyMapper;
import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.Reply;
import com.noi.oj.service.ReplyService;
import com.noi.oj.service.UsersService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private UsersService usersService;

    @Override
    public int insert(Reply record){
        return replyMapper.insertSelective(record);
    }

    @Override
    public int update(Reply record){
        return replyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(Integer id){
        Reply reply = new Reply();
        reply.setId(id);
        reply.setIsDelete(new Byte("1"));
        return update(reply);
    }

    @Override
    public List<Reply> select(Conditions record){
        int count = replyMapper.count(record);
        if(count<1)
            return null;
        List<Reply> replies = replyMapper.selectList(record);
        for(Reply reply:replies)
            reply.setUsers(usersService.selectUserInfo(reply.getUserId()));
        return replies;
    }

}
