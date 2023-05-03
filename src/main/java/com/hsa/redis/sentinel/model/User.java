package com.hsa.redis.sentinel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import lombok.Builder;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@Builder(toBuilder = true)
//@JsonDeserialize(
//    builder = User.UserBuilder.class
//)
public class User implements Serializable {

  @JsonProperty
  String id;

  @JsonProperty
  String firstName;
  @JsonProperty
  String lastName;


  public User(String id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public User() {
  }
}
