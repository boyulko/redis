package com.hsa.redis.sentinel.controller;

import com.hsa.redis.sentinel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/users")
  public void createUser() throws InterruptedException {
    userService.createUser();
  }

}
