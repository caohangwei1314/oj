package com.noi.oj.service;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.ProblemPacket;
import com.noi.oj.utils.PageBean;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface PacketService {

    int deleteByPrimaryKey(Integer packetId);

    int insertSelective(ProblemPacket record, HttpServletRequest request);

    ProblemPacket selectByPrimaryKey(Integer packetId);

    PageBean selectList(Conditions record);

    int updateByPrimaryKeySelective(ProblemPacket record);

    String setPacketProfile(MultipartFile file);

    boolean setPacketProfile(MultipartFile profile,Integer pkId);

    int isBuy(ProblemPacket record);

}
