package com.noi.oj.dao;

import com.noi.oj.domain.Loginlog;
import com.noi.oj.domain.LoginlogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginlogMapper {
    long countByExample(LoginlogExample example);

    int deleteByExample(LoginlogExample example);

    int insert(Loginlog record);

    int insertSelective(Loginlog record);

    List<Loginlog> selectByExample(LoginlogExample example);

    int updateByExampleSelective(@Param("record") Loginlog record, @Param("example") LoginlogExample example);

    int updateByExample(@Param("record") Loginlog record, @Param("example") LoginlogExample example);
}