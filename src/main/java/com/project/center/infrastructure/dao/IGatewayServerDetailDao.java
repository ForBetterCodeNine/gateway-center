package com.project.center.infrastructure.dao;

import com.project.center.infrastructure.po.GatewayServerDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IGatewayServerDetailDao {

    void insert(GatewayServerDetail gatewayServerDetail);

    GatewayServerDetail queryGatewayServerDetail(GatewayServerDetail gatewayServerDetail);

    boolean updateGatewayStatus(GatewayServerDetail gatewayServerDetail);
}
