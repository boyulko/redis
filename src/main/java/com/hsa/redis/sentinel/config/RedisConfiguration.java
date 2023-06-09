package com.hsa.redis.sentinel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfiguration {

  @Value("spring.data.redis.sentinel.master")
  private String hostname;

  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    JedisConnectionFactory jedisConFactory
        = new JedisConnectionFactory();
    jedisConFactory.setHostName(hostname);
    jedisConFactory.setPort(6379);
    return jedisConFactory;
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate() {
    final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    template.setConnectionFactory(jedisConnectionFactory());
    template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
    return template;
  }

}
