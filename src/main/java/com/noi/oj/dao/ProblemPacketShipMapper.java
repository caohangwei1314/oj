package com.noi.oj.dao;

import com.noi.oj.domain.ProblemPacketShip;
import com.noi.oj.domain.ProblemPacketShipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProblemPacketShipMapper {
    long countByExample(ProblemPacketShipExample example);

    int deleteByExample(ProblemPacketShipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProblemPacketShip record);

    int insertSelective(ProblemPacketShip record);

    List<ProblemPacketShip> selectByExample(ProblemPacketShipExample example);

    ProblemPacketShip selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProblemPacketShip record, @Param("example") ProblemPacketShipExample example);

    int updateByExample(@Param("record") ProblemPacketShip record, @Param("example") ProblemPacketShipExample example);

    int updateByPrimaryKeySelective(ProblemPacketShip record);

    int updateByPrimaryKey(ProblemPacketShip record);
}