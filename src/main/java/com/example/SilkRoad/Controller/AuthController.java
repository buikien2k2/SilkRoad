package com.example.SilkRoad.Controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SilkRoad.Service.impl.UserService;
import com.example.SilkRoad.requestDTO.LoginUserDTO;
import com.example.SilkRoad.requestDTO.RegisterUserDTO;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    private final UserService userService;

    // @PostMapping(value = { "/login" })
    // public String login(@RequestParam String email, @RequestParam String
    // password) {
    // User user = userService.getUserByEmail(email);

    // if (user != null) {
    // if (password.equals(user.getPassword())) {
    // // Handle successful login
    // System.out.println("Thành công");
    // return "redirect:/login";
    // }
    // }
    // return "redirect:/login?error";
    // }

    @GetMapping("/login")
    public String getLogin(Model model, @AuthenticationPrincipal UserDetails user) {
        if (user != null) {
            return "redirect:/home";
        }
        model.addAttribute("LoginUserDTO", new LoginUserDTO());
        return "signIn";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginUserDTO loginUserDTO, BindingResult bdResult, Model model) {
        try {
            if (bdResult.hasErrors()) {
                bdResult.getAllErrors().forEach(error -> System.out.println(error));
                return "redirect:/login";
            }

            Authentication authentication = new UsernamePasswordAuthenticationToken(loginUserDTO.getEmail(),
                    loginUserDTO.getPassword());
            Authentication result = authenticationManager.authenticate(authentication);
            if (result.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(result);
                return "redirect:/home";
            }

            // Nếu thất bại, trả về lỗi cho user
            model.addAttribute("error", "Username hoặc password không chính xác.");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/login";
        }
    }

    @GetMapping("/signUp")
    public String signupForm(Model model, @AuthenticationPrincipal UserDetails user) {
        if (user != null) {
            return "redirect:/home";
        }
        model.addAttribute("registerUserDTO", new RegisterUserDTO());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signup(@Valid @ModelAttribute("registerUserDTO") RegisterUserDTO registerUserDTO,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "/signUp";
        }

        registerUserDTO.setRole("USER");
        userService.registerAccount(registerUserDTO);
        return "redirect:/login";
    }

}
