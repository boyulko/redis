package com.hsa.redis.sentinel.service;

import com.hsa.redis.sentinel.model.User;
import com.hsa.redis.sentinel.redis.repository.UserRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void createUser() throws InterruptedException {
    String userId = UUID.randomUUID().toString();
    User user = new User(userId, "John", "Black");
    userRepository.save(user);
    Optional<User> byId = userRepository.findById(userId);

    // user will expire after 3 seconds according to config in User
    Thread.sleep(1000);
    Optional<User> byIdAfterExpiration = userRepository.findById(userId);

  }
}
