package com.java_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {
  @RequestMapping("/login")
  public String login() {
    return "login";
  }
}
