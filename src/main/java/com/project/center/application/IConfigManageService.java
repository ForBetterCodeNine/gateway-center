package com.project.center.application;

import com.project.center.domain.manage.model.aggregates.ApplicationSystemRichInfo;
import com.project.center.domain.manage.model.vo.GatewayServerDetailVO;
import com.project.center.domain.manage.model.vo.GatewayServerVO;

import java.util.List;

public interface IConfigManageService {

    List<GatewayServerVO> queryGatewayServerList();

    List<GatewayServerDetailVO> queryGatewayServerDetailList();

    boolean registryGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress);

    ApplicationSystemRichInfo queryApplicationSystemRichInfo(String gatewayId);

    String queryGatewayDistribution(String systemId);
}
