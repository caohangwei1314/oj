package com.noi.oj.dao;

import com.noi.oj.domain.ShareCode;
import com.noi.oj.domain.ShareCodeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ShareCodeMapper {
    long countByExample(ShareCodeExample example);

    int deleteByExample(ShareCodeExample example);

    int deleteByPrimaryKey(Integer shareId);

    int insert(ShareCode record);

    int insertSelective(ShareCode record);

    List<ShareCode> selectByExampleWithBLOBs(ShareCodeExample example);

    List<ShareCode> selectByExample(ShareCodeExample example);

    ShareCode selectByPrimaryKey(Integer shareId);

    int updateByExampleSelective(@Param("record") ShareCode record, @Param("example") ShareCodeExample example);

    int updateByExampleWithBLOBs(@Param("record") ShareCode record, @Param("example") ShareCodeExample example);

    int updateByExample(@Param("record") ShareCode record, @Param("example") ShareCodeExample example);

    int updateByPrimaryKeySelective(ShareCode record);

    int updateByPrimaryKeyWithBLOBs(ShareCode record);

    int updateByPrimaryKey(ShareCode record);
}