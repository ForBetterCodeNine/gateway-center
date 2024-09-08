package com.project.center.domain.docker.service;
import com.project.center.domain.docker.model.aggregates.NginxConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.center.application.ILoadBalancingService;

import java.io.IOException;

/**
 * 负载均衡抽象类
 */
public abstract class AbstractLoadBalancing implements ILoadBalancingService {
    private Logger logger = LoggerFactory.getLogger(AbstractLoadBalancing.class);

    @Override
    public void updateNginxConfig(NginxConfig nginxConfig) {
        String containerFilePath = createNginxConfigFile(nginxConfig);
        logger.info("步骤1：创建 Nginx 配置文件 containerFilePath：{}", containerFilePath);
        refreshNginxConfig(nginxConfig);
        logger.info("步骤2：刷新 Nginx 配置文件 Done！");
    }

    protected abstract String createNginxConfigFile(NginxConfig nginxConfig) throws IOException;

    protected abstract void refreshNginxConfig(NginxConfig nginxConfig) throws Exception;
}
