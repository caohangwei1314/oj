package com.noi.oj.dao;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.ProblemPacket;
import com.noi.oj.domain.ProblemPacketExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProblemPacketMapper {
    long countByExample(ProblemPacketExample example);

    int deleteByExample(ProblemPacketExample example);

    int deleteByPrimaryKey(Integer packetId);

    int insert(ProblemPacket record);

    int insertSelective(ProblemPacket record);

    List<ProblemPacket> selectByExampleWithBLOBs(ProblemPacketExample example);

    List<ProblemPacket> selectByExample(ProblemPacketExample example);

    ProblemPacket selectByPrimaryKey(Integer packetId);

    int updateByExampleSelective(@Param("record") ProblemPacket record, @Param("example") ProblemPacketExample example);

    int updateByExampleWithBLOBs(@Param("record") ProblemPacket record, @Param("example") ProblemPacketExample example);

    int updateByExample(@Param("record") ProblemPacket record, @Param("example") ProblemPacketExample example);

    int updateByPrimaryKeySelective(ProblemPacket record);

    int updateByPrimaryKeyWithBLOBs(ProblemPacket record);

    int updateByPrimaryKey(ProblemPacket record);

    int count(String name);

    List<ProblemPacket> selectList(Conditions record);
}