package com.hsa.redis.sentinel.model;

import java.io.Serializable;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(timeToLive=3)
public class User implements Serializable {

  String id;

  String firstName;
  String lastName;


  public User(String id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
