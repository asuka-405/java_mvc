package com.java_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class Dashboard {

  @GetMapping("/dashboard")
  public String dashboard(@CookieValue(value = "username") String jwt, Model model) {

    System.out.println("username: " + jwt);

    // if (username != null) {
    model.addAttribute("username", jwt);
    return "dashboard";
    // }
    // return "redirect:/login";
  }
}