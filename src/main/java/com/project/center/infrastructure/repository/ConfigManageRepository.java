package com.project.center.infrastructure.repository;

import com.project.center.domain.manage.model.vo.GatewayServerDetailVO;
import com.project.center.domain.manage.model.vo.GatewayServerVO;
import com.project.center.domain.manage.repository.IConfigManageRepository;
import com.project.center.infrastructure.dao.IGatewayServerDao;
import com.project.center.infrastructure.dao.IGatewayServerDetailDao;
import com.project.center.infrastructure.po.GatewayServer;
import com.project.center.infrastructure.po.GatewayServerDetail;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ConfigManageRepository implements IConfigManageRepository {

    @Resource
    private IGatewayServerDao gatewayServerDao;

    @Resource
    private IGatewayServerDetailDao gatewayServerDetailDao;


    @Override
    public List<GatewayServerVO> queryGatewayServerList() {
        List<GatewayServer> gatewayServerList = gatewayServerDao.queryGatewayServerList();
        if(gatewayServerList == null || gatewayServerList.size() == 0) return Collections.emptyList();
        List<GatewayServerVO> gatewayServerVOS = new ArrayList<>(gatewayServerList.size());
        for(GatewayServer gatewayServer : gatewayServerList) {
            GatewayServerVO vo = new GatewayServerVO();
            vo.setGroupId(gatewayServer.getGroupId());
            vo.setGroupName(gatewayServer.getGroupName());
            gatewayServerVOS.add(vo);
        }
        return gatewayServerVOS;
    }

    @Override
    public boolean registryGatewayServerNode(String groupId, String gatewayId, String gatewayName, String address, Integer available) {
        GatewayServerDetail detail = new GatewayServerDetail();
        detail.setGatewayId(gatewayId);
        detail.setGroupId(groupId);
        detail.setStatus(available);
        detail.setGatewayName(gatewayName);
        detail.setGatewayAddress(address);
        gatewayServerDetailDao.insert(detail);
        return true;
    }

    @Override
    public GatewayServerDetailVO queryGatewayServerDetail(String gatewayId, String gatewayAddress) {
        GatewayServerDetail gatewayServerDetailReq = new GatewayServerDetail();
        gatewayServerDetailReq.setGatewayId(gatewayId);
        gatewayServerDetailReq.setGatewayAddress(gatewayAddress);
        GatewayServerDetail gatewayServerDetailRes = gatewayServerDetailDao.queryGatewayServerDetail(gatewayServerDetailReq);
        if(gatewayServerDetailRes == null) return null;
        GatewayServerDetailVO gatewayServerDetailVO = new GatewayServerDetailVO();
        gatewayServerDetailVO.setGatewayAddress(gatewayServerDetailRes.getGatewayAddress());
        gatewayServerDetailVO.setGatewayId(gatewayServerDetailRes.getGatewayId());
        gatewayServerDetailVO.setGatewayName(gatewayServerDetailRes.getGatewayName());
        gatewayServerDetailVO.setStatus(gatewayServerDetailRes.getStatus());
        return gatewayServerDetailVO;
    }

    @Override
    public boolean updateGatewayStatus(String gatewayId, String gatewayAddress, Integer available) {
        GatewayServerDetail gatewayServerDetail = new GatewayServerDetail();
        gatewayServerDetail.setGatewayId(gatewayId);
        gatewayServerDetail.setGatewayAddress(gatewayAddress);
        gatewayServerDetail.setStatus(available);
        return gatewayServerDetailDao.updateGatewayStatus(gatewayServerDetail);
    }
}
