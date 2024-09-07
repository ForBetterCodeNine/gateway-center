package com.project.center.domain.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class Publisher {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public Publisher(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void pushMessage(String topic, Object message) {
        redisTemplate.convertAndSend(topic, message);
    }

}
