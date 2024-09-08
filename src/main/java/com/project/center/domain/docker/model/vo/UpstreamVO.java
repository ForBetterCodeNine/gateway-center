package com.project.center.domain.docker.model.vo;

import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 设定负载均衡的服务器列表
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class UpstreamVO {

    /** 名称 */
    private String name;
    /** 复杂策略；least_conn;、 ip_hash; */
    private String strategy;
    /** 服务列表；192.168.1.102:9001; */
    private List<String> servers;

    public UpstreamVO(String name, String strategy, List<String> servers) {
        this.name = name;
        this.strategy = strategy;
        this.servers = servers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }
}
