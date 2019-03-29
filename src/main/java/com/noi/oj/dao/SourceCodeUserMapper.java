package com.noi.oj.dao;

import com.noi.oj.domain.SourceCodeUser;
import com.noi.oj.domain.SourceCodeUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SourceCodeUserMapper {
    long countByExample(SourceCodeUserExample example);

    int deleteByExample(SourceCodeUserExample example);

    int deleteByPrimaryKey(Integer solutionId);

    int insert(SourceCodeUser record);

    int insertSelective(SourceCodeUser record);

    List<SourceCodeUser> selectByExampleWithBLOBs(SourceCodeUserExample example);

    List<SourceCodeUser> selectByExample(SourceCodeUserExample example);

    SourceCodeUser selectByPrimaryKey(Integer solutionId);

    int updateByExampleSelective(@Param("record") SourceCodeUser record, @Param("example") SourceCodeUserExample example);

    int updateByExampleWithBLOBs(@Param("record") SourceCodeUser record, @Param("example") SourceCodeUserExample example);

    int updateByExample(@Param("record") SourceCodeUser record, @Param("example") SourceCodeUserExample example);

    int updateByPrimaryKeySelective(SourceCodeUser record);

    int updateByPrimaryKeyWithBLOBs(SourceCodeUser record);
}