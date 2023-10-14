package com.alibou.oauth2.landleasing.login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dynamic/api/profile")
public class LandLeasingLoginRestController {

  @GetMapping
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Thank you for login Land Leasing Site");
  }
}
