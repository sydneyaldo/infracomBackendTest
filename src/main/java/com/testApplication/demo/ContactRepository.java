package com.testApplication.demo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, String> {
  @Query("SELECT c FROM Contact c WHERE c.userId = ?1")
  ArrayList<Contact> findByUserId(String userId);
}