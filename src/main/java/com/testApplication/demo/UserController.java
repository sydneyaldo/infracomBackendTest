package com.testApplication.demo;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@RestController
class UserController {
  private UserBusiness userBusiness;
  private ContactBusiness contactBusiness;

  UserController(
    UserBusiness userBusiness,
    ContactBusiness contactBusiness
  ) {
    this.userBusiness = userBusiness;
    this.contactBusiness = contactBusiness;
  }

  @GetMapping("/user/{id}")
  JSONObject getUser(@PathVariable String id) {
    // spring bean

    Optional<User> user = userBusiness.get(id);

    JSONObject result = user.isPresent() ? user.get().toJson() : new JSONObject();

    return result;
  }

  @GetMapping("/user/{id}/contacts")
  JSONObject getContacts(@PathVariable String id) {
    Optional<User> user = userBusiness.get(id);
    ArrayList<Contact> contacts = contactBusiness.get(id);

    JSONObject result = new JSONObject();

    if(user.isPresent()) {
      result.put("user", user.get().toJson());
      
      JSONArray contactsJson = new JSONArray();

      for(Contact c : contacts) {
        contactsJson.add(c.toJson());
      }

      result.put("contacts", contactsJson);
    }

    return result;
  }
}