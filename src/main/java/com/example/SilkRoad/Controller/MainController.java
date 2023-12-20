package com.example.SilkRoad.Controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.SilkRoad.Model.User;
import com.example.SilkRoad.Service.UserServiceInterface;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    @Autowired
    private UserServiceInterface userService;

    // @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    // public String home(@AuthenticationPrincipal UserDetails user, Model model) {
    // if (user == null) {
    // return "redirect:/login";
    // }
    // System.out.println(user.getUsername());
    // User userLoggedIn = userService.getUserByEmail(user.getUsername());
    // model.addAttribute("user", userLoggedIn);
    // return "index";
    // }

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

    // @GetMapping("/error")
    // public String error() {
    // return "error";
    // }
}
