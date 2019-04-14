package com.noi.oj.service.impl;

import com.noi.oj.dao.ProblemMapper;
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
import com.noi.oj.utils.SystemConstant;
import com.noi.oj.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Service
public class PacketImpl implements PacketService {

    private static final String NAME="packet";

    @Autowired
    private ProblemPacketMapper problemPacketMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private ProblemMapper problemMapper;

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
        ProblemPacket problemPacket = problemPacketMapper.selectByPrimaryKey(packetId);
        Conditions record = new Conditions();
        record.setPacketId(problemPacket.getPacketId());
        problemPacket.setCount(problemPacketMapper.count(record));
        problemPacket.setImage(getUrl(problemPacket.getImage()));
        return problemPacket;
    }

    @Override
    public PageBean selectList(Conditions record){
        int count = problemPacketMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit());
        record.setOffset(pageBean.getStart());
        List<ProblemPacket> packets = problemPacketMapper.selectList(record);
        if(packets!=null&&packets.size()>0){
            Conditions conditions = new Conditions();
            for(ProblemPacket packet : packets){
                conditions.setPacketId(packet.getPacketId());
                packet.setImage(getUrl(packet.getImage()));
                packet.setCount(problemMapper.count(conditions));
            }
            pageBean.setList(packets);
        }
        else
            return null;
        return pageBean;
    }

    @Override
    public int updateByPrimaryKeySelective(ProblemPacket record){
        return problemPacketMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public String setPacketProfile(MultipartFile profile){
        String[] originName = profile.getOriginalFilename().split("\\.");
        String suffix = originName[originName.length - 1];
        String name = UUID.randomUUID().toString() + System.currentTimeMillis() + "." + suffix;
        if(UploadUtils.setProductProfile(profile,name, SystemConstant.LINUX_PACKET_PATH)){
            return UploadUtils.getUrl(name,NAME);
        }else{
            return null;
        }
    }

    @Override
    public boolean setPacketProfile(MultipartFile profile,Integer pkId){
        ProblemPacket packet = problemPacketMapper.selectByPrimaryKey(pkId);
        String name = new String();
        if("".equals(packet.getImage())||packet.getImage()==null){
            String[] originName = profile.getOriginalFilename().split("\\.");
            String suffix = originName[originName.length - 1];
            name = UUID.randomUUID().toString() + System.currentTimeMillis() + "." + suffix;
        }
        if(UploadUtils.setProductProfile(profile,name,SystemConstant.LINUX_PACKET_PATH)){
            packet.setImage(name);
            return updateByPrimaryKeySelective(packet)>0;
        }else{
            return false;
        }
    }

    @Override
    public int isBuy(ProblemPacket record){
        if(problemPacketMapper.isBuy(record) != null)
            return 1;
        else
            return 0;
    }

    private String getUrl(String path){
        if("".equals(path) || path==null)
            return null;
        return UploadUtils.getUrl(path,NAME);
    }
}
