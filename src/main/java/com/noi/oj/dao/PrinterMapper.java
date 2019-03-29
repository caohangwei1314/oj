package com.noi.oj.dao;

import com.noi.oj.domain.Printer;
import com.noi.oj.domain.PrinterExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PrinterMapper {
    long countByExample(PrinterExample example);

    int deleteByExample(PrinterExample example);

    int deleteByPrimaryKey(Integer printerId);

    int insert(Printer record);

    int insertSelective(Printer record);

    List<Printer> selectByExampleWithBLOBs(PrinterExample example);

    List<Printer> selectByExample(PrinterExample example);

    Printer selectByPrimaryKey(Integer printerId);

    int updateByExampleSelective(@Param("record") Printer record, @Param("example") PrinterExample example);

    int updateByExampleWithBLOBs(@Param("record") Printer record, @Param("example") PrinterExample example);

    int updateByExample(@Param("record") Printer record, @Param("example") PrinterExample example);

    int updateByPrimaryKeySelective(Printer record);

    int updateByPrimaryKeyWithBLOBs(Printer record);

    int updateByPrimaryKey(Printer record);
}