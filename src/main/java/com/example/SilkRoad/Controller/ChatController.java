/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SilkRoad.Controller;
        
import com.example.SilkRoad.Model.Chat;
import javax.validation.Path;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatController {
    

    @GetMapping("/chat")
    public String Profile(@PathVariable("userid") int userid, Model model,
            @AuthenticationPrincipal UserDetails userDetailsLoggedIn) {
        if (userDetailsLoggedIn == null) {
            return "redirect:/login";
        }
        return "chat";
    }

    @MessageMapping("/chat/chat.sendMessage")
    @SendTo("/chat/topic/public")
    public Chat sendMessage(
            @Payload Chat chat
    ) {
        return chat;
    }

    @MessageMapping("/chat/chat.addUser")
    @SendTo("/chat/topic/public")
    public Chat addUser(
            @Payload Chat chat,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chat.getSender());
        return chat;
    }
}

//    @RequestMapping("/")
//    public String index(HttpServletRequest request, Model model) {
//        String username = (String) request.getSession().getAttribute("username");
//
//        if (username == null || username.isEmpty()) {
//            return "redirect:/login";
//        }
//        model.addAttribute("username", username);
//
//        return "chat";
//    }
//
//    @RequestMapping(path = "/login", method = RequestMethod.GET)
//    public String showLoginPage() {
//        return "login";
//    }
//
//    @RequestMapping(path = "/login", method = RequestMethod.POST)
//    public String doLogin(HttpServletRequest request, @RequestParam(defaultValue = "") String username) {
//        username = username.trim();
//
//        if (username.isEmpty()) {
//            return "login";
//        }
//        request.getSession().setAttribute("username", username);
//
//        return "redirect:/";
//    }
//
//    @RequestMapping(path = "/logout")
//    public String logout(HttpServletRequest request) {
//        request.getSession(true).invalidate();
//
//        return "redirect:/login";
//    }




