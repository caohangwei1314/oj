package com.noi.oj.dao;

import com.noi.oj.domain.Mail;
import com.noi.oj.domain.MailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MailMapper {
    long countByExample(MailExample example);

    int deleteByExample(MailExample example);

    int deleteByPrimaryKey(Integer mailId);

    int insert(Mail record);

    int insertSelective(Mail record);

    List<Mail> selectByExampleWithBLOBs(MailExample example);

    List<Mail> selectByExample(MailExample example);

    Mail selectByPrimaryKey(Integer mailId);

    int updateByExampleSelective(@Param("record") Mail record, @Param("example") MailExample example);

    int updateByExampleWithBLOBs(@Param("record") Mail record, @Param("example") MailExample example);

    int updateByExample(@Param("record") Mail record, @Param("example") MailExample example);

    int updateByPrimaryKeySelective(Mail record);

    int updateByPrimaryKeyWithBLOBs(Mail record);

    int updateByPrimaryKey(Mail record);
}