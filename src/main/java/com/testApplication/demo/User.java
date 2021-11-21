package com.testApplication.demo;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.minidev.json.JSONObject;

import javax.persistence.Id;

@Entity
@Table(name = "USER")
class User {
  User() {

  };

  @Id
  private String id;
  private String name;
  private int age;

  User(String id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  JSONObject toJson() {
    JSONObject result = new JSONObject();
    result.put("id", this.id);
    result.put("name", this.name);
    result.put("age", this.age);

    return result;
  }
}