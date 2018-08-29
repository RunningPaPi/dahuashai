package com.artqiyi.dahuashai.system.mapper;

import com.artqiyi.dahuashai.system.domain.SystemDistribution;
import com.artqiyi.dahuashai.system.domain.SystemDistributionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemDistributionMapper {
    long countByExample(SystemDistributionExample example);

    int deleteByExample(SystemDistributionExample example);

    int deleteByPrimaryKey(Integer distrId);

    int insert(SystemDistribution record);

    int insertSelective(SystemDistribution record);

    List<SystemDistribution> selectByExample(SystemDistributionExample example);

    SystemDistribution selectByPrimaryKey(Integer distrId);

    int updateByExampleSelective(@Param("record") SystemDistribution record, @Param("example") SystemDistributionExample example);

    int updateByExample(@Param("record") SystemDistribution record, @Param("example") SystemDistributionExample example);

    int updateByPrimaryKeySelective(SystemDistribution record);

    int updateByPrimaryKey(SystemDistribution record);
}