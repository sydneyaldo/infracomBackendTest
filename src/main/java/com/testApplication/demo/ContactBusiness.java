package com.testApplication.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

public class ContactBusiness {
  ContactBusiness() {

  }

  @Autowired
  private ContactRepository repository;

  public ArrayList<Contact> get(String userId) {
    return repository.findByUserId(userId);
	}
}