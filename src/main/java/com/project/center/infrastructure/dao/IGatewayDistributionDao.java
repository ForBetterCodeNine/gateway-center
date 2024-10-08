package com.project.center.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGatewayDistributionDao {

    List<String> queryGatewayDistributionSystemList();

    String queryGatewayDistribution(String systemId);
}
