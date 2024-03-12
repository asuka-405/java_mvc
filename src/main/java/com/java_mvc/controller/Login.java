package com.java_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class Login {

  @GetMapping("/auth/login")
  public String loginHandler(
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      Model model,
      HttpServletResponse response) {

    if (username.equals("admin") && password.equals("admin")) {

      Cookie cookie = new Cookie("username", username);
      cookie.setMaxAge(3600);
      response.addCookie(cookie);
      return "redirect:/dashboard";
    }
    model.addAttribute("errorMessage", "Invalid username or password");
    return "login";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }
}
