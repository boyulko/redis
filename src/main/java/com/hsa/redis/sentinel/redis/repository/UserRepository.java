package com.hsa.redis.sentinel.redis.repository;

import com.hsa.redis.sentinel.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
