package com.project.center.application;

import java.util.Map;

/**
 * 消息服务
 */
public interface IMessageService {
    Map<String, String> queryRedisConfig();

    void pushMessage(String gatewayId, Object message);
}
