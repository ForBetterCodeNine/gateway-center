package com.project.center.domain.manage.repository;

import com.project.center.domain.manage.model.vo.GatewayServerDetailVO;
import com.project.center.domain.manage.model.vo.GatewayServerVO;

import java.util.List;

public interface IConfigManageRepository {
    List<GatewayServerVO> queryGatewayServerList();

    boolean registryGatewayServerNode(String groupId, String gatewayId, String gatewayName, String addresss, Integer available);

    GatewayServerDetailVO queryGatewayServerDetail(String gatewayId, String gatewayAddress);

    boolean updateGatewayStatus(String gatewayId, String gatewayAddress, Integer available);
}
