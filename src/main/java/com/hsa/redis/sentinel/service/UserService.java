package com.hsa.redis.sentinel.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsa.redis.sentinel.model.User;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final RedisTemplate<String, Object> redisTemplate;

  @Autowired
  public UserService(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public void createUser() throws InterruptedException, JsonProcessingException {
    String userId = UUID.randomUUID().toString();
    User user = new User(userId, "John", "Black");
    ObjectMapper objectMapper = new ObjectMapper();

    redisTemplate.opsForValue().set(userId, objectMapper.writeValueAsString(user));
    User userFromCache = objectMapper.readValue(redisTemplate.opsForValue().get(userId).toString(), User.class);
    redisTemplate.expire(userId, 1, TimeUnit.SECONDS);

    Thread.sleep(2000);
    // null object cause key already expired
    Object nullUser = redisTemplate.opsForValue().get(userId);


  }
}
