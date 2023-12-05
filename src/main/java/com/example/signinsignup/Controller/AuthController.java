package com.example.signinsignup.Controller;

import com.example.signinsignup.Model.User;
import com.example.signinsignup.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping(value = {"/login"})
    public String login(@RequestParam String email, @RequestParam String password) {
        User user = userService.getUserByEmail(email);

        if (user != null) {
            if (password.equals(user.getPassword())){
                // Handle successful login
                System.out.println("Thành công");
                return "redirect:/login";
            }
        }
        return "redirect:/login?error";
    }

    @GetMapping("/signUp")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "signUp";
    }
    @PostMapping("/signUp")
    public String signup(@ModelAttribute User user, @RequestParam("day") int day,
                         @RequestParam("month") int month, @RequestParam("year") int year) {
        if (userService.getUserByEmail(user.getEmail()) != null) {
            return "redirect:/signUp?error";
        }
        LocalDate birthDate = LocalDate.of(user.getYear(), user.getMonth(), user.getDay());
        user.setBirth(java.sql.Date.valueOf(birthDate)); // Chuyển đổi thành java.sql.Date


        userService.addUser(user);
        return "redirect:/login";
    }
}
