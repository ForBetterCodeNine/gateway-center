package com.project.center.application;

import com.project.center.domain.docker.model.aggregates.NginxConfig;

/**
 * 负载均衡配置服务
 */
public interface ILoadBalancingService {
    void updateNginxConfig(NginxConfig nginxConfig);
}
