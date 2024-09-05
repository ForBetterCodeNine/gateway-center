package com.project.center.application;

import com.project.center.domain.manage.model.vo.GatewayServerVO;

import java.util.List;

public interface IConfigManageService {

    List<GatewayServerVO> queryGatewayServerList();

    boolean registryGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress);


}
