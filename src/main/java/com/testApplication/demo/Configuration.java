package com.testApplication.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
class Config {
  public UserController userController() {
    return new UserController(userBusiness(), contactBusiness());
  }

  @Bean
  public UserBusiness userBusiness() {
    return new UserBusiness();
  }

  @Bean
  public ContactBusiness contactBusiness() {
    return new ContactBusiness();
  }
}