package com.example.home;

import com.example.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping({"/", "/home"})
    public String viewHomePage(Model model) {
        String name = userService.getUsername();
        model.addAttribute("name", name);
        if (userService.isLogin()) {
            return "home_login";
        }
        else {
            return "home";
        }

    }
}