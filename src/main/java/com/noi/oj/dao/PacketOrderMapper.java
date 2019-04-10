package com.noi.oj.dao;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.PacketOrder;
import com.noi.oj.domain.PacketOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PacketOrderMapper {
    long countByExample(PacketOrderExample example);

    int deleteByExample(PacketOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(PacketOrder record);

    int insertSelective(PacketOrder record);

    List<PacketOrder> selectByExample(PacketOrderExample example);

    PacketOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") PacketOrder record, @Param("example") PacketOrderExample example);

    int updateByExample(@Param("record") PacketOrder record, @Param("example") PacketOrderExample example);

    int updateByPrimaryKeySelective(PacketOrder record);

    int updateByPrimaryKey(PacketOrder record);

    int count(Conditions record);

    List<PacketOrder> selectList(Conditions record);
}