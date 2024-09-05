package com.project.center.domain.manage.service;

import com.project.center.application.IConfigManageService;
import com.project.center.domain.manage.model.vo.GatewayServerDetailVO;
import com.project.center.domain.manage.model.vo.GatewayServerVO;
import com.project.center.domain.manage.repository.IConfigManageRepository;
import com.project.center.infrastructure.common.Constants;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


@Service
public class ConfigManageService implements IConfigManageService {

    @Resource
    private IConfigManageRepository configManageRepository;


    @Override
    public List<GatewayServerVO> queryGatewayServerList() {
        return configManageRepository.queryGatewayServerList();
    }

    @Override
    public boolean registryGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress) {
        GatewayServerDetailVO gatewayServerDetailVO = configManageRepository.queryGatewayServerDetail(gatewayId, gatewayAddress);
        if(gatewayServerDetailVO == null) {
            try {
                return configManageRepository.registryGatewayServerNode(groupId, gatewayId, gatewayName, gatewayAddress, Constants.GatewayStatus.Available);
            }catch (DuplicateKeyException e) {
                return configManageRepository.updateGatewayStatus(gatewayId, gatewayAddress, Constants.GatewayStatus.Available);
            }
        }else {
            return configManageRepository.updateGatewayStatus(gatewayId, gatewayAddress, Constants.GatewayStatus.Available);
        }
    }
}
