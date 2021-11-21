package com.testApplication.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import net.minidev.json.JSONObject;

@Entity
@Table(name="CONTACT")
public class Contact {
  Contact() {

  }

  public Contact(String id, String address, String userId) {
    this.id = id;
    this.address = address;
    this.userId = userId;
	}
  
  @Id
  private String id;
  private String address;
  private String userId;

  public JSONObject toJson() {
    JSONObject result = new JSONObject();
    result.put("id", this.id);
    result.put("address", this.address);

    return result;
  }
}