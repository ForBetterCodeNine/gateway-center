package com.project.center.interfaces;


import com.project.center.application.IConfigManageService;
import com.project.center.domain.manage.model.aggregates.ApplicationSystemRichInfo;
import com.project.center.domain.manage.model.vo.GatewayServerVO;
import com.project.center.infrastructure.common.ResponseCode;
import com.project.center.infrastructure.common.Result;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * 网关配置管理；服务分组、网关注册、服务关联
 */
@RestController
@RequestMapping("/wg/admin/config")
public class GatewayConfigManage {
    private Logger logger = LoggerFactory.getLogger(GatewayConfigManage.class);

    @Resource
    private IConfigManageService configManageService;

    @GetMapping(value = "queryServerConfig", produces = "application/json;charset=utf-8")
    public Result<List<GatewayServerVO>> queryServerConfig() {
        try {
            logger.info("查询网关服务配置项信息");
            List<GatewayServerVO> gatewayServerVOS = configManageService.queryGatewayServerList();
            return new Result<>(ResponseCode.SUCCESS.getCode(),  ResponseCode.SUCCESS.getInfo(), gatewayServerVOS);
        }catch (Exception e) {
            logger.error("查询网关服务配置项信息异常", e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), ResponseCode.UN_ERROR.getInfo(), null);
        }
    }

    /**
     * 注册网关节点
     */
    @PostMapping(value = "registryGateway", produces = "application/json;charset=utf-8")
    public Result<Boolean> registryGateway(@RequestParam String groupId,
                                           @RequestParam String gatewayId,
                                           @RequestParam String gatewayName,
                                           @RequestParam String gatewayAddress) {
        try {
            logger.info("注册网关服务节点 gatewayId：{} gatewayName：{} gatewayAddress：{}", gatewayId, gatewayName, gatewayAddress);
            boolean status = configManageService.registryGatewayServerNode(groupId, gatewayId, gatewayName, gatewayAddress);
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), status);
        }catch (Exception e) {
            return new Result<>(ResponseCode.UN_ERROR.getCode(), ResponseCode.UN_ERROR.getInfo(), false);
        }
    }

    @PostMapping(value = "queryApplicationSystemRichInfo", produces = "application/json;charset=utf-8")
    public Result<ApplicationSystemRichInfo> queryApplicationSystemRichInfo(@RequestParam String gatewayId) {
        try {
            logger.info("查询分配到网关下的待注册系统信息(系统、接口、方法) gatewayId：{}", gatewayId);
            ApplicationSystemRichInfo richInfo = configManageService.queryApplicationSystemRichInfo(gatewayId);
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), richInfo);
        }catch (Exception e) {
            logger.error("查询分配到网关下的待注册系统信息(系统、接口、方法)异常 gatewayId：{}", gatewayId, e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), null);
        }
    }

}
