package com.example.SilkRoad.Controller;

import lombok.AllArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {
    @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public String home(@AuthenticationPrincipal UserDetails user) {
        if (user == null) {
            return "redirect:/login";
        }
        System.out.println(user.getUsername());
        return "index";
    }

    @GetMapping("/")
    public String index(@AuthenticationPrincipal UserDetails user) {
        if (user == null) {
            return "redirect:/login";
        }
        return "redirect:/home";
    }

    @GetMapping("/403")
    public String forbidden() {
        return "403";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
