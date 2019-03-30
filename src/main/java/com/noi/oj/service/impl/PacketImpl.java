package com.noi.oj.service.impl;

import com.noi.oj.dao.ProblemPacketMapper;
import com.noi.oj.dao.ProblemPacketShipMapper;
import com.noi.oj.dao.UsersMapper;
import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.ProblemPacket;
import com.noi.oj.domain.ProblemPacketShip;
import com.noi.oj.domain.Users;
import com.noi.oj.service.PacketService;
import com.noi.oj.service.ProblemService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class PacketImpl implements PacketService {

    @Autowired
    private ProblemPacketMapper problemPacketMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int deleteByPrimaryKey(Integer packetId){
        ProblemPacket packet = new ProblemPacket();
        packet.setPacketId(packetId);
        packet.setStatus(new Byte("0"));
        return updateByPrimaryKeySelective(packet);
    }

    @Override
    public int insertSelective(ProblemPacket record, HttpServletRequest request){
        Users users = usersMapper.selectByPrimaryKey(Long.parseLong(request.getAttribute("userId").toString()));
        record.setUserId(users.getUserId());
        record.setAuthor(users.getNick());
        return problemPacketMapper.insertSelective(record);
    }

    @Override
    public ProblemPacket selectByPrimaryKey(Integer packetId){
        return problemPacketMapper.selectByPrimaryKey(packetId);
    }

    @Override
    public PageBean selectList(Conditions record){
        int count = problemPacketMapper.count(record.getTitle());
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit());
        record.setOffset(pageBean.getStart());
        List<ProblemPacket> packets = problemPacketMapper.selectList(record);
        if(packets!=null&&packets.size()>0)
            pageBean.setList(packets);
        else
            return null;
        return pageBean;
    }

    @Override
    public int updateByPrimaryKeySelective(ProblemPacket record){
        return problemPacketMapper.updateByPrimaryKeySelective(record);
    }
}
