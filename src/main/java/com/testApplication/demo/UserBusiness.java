package com.testApplication.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

class UserBusiness {
  UserBusiness() {

  };

  @Autowired
  private UserRepository userRepository;
  
  public Optional<User> get(String id) {
    Optional<User> result = userRepository.findById(id);

    return result;
  }
}