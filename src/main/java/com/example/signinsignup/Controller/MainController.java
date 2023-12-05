package com.example.signinsignup.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@AllArgsConstructor
public class MainController {
    @RequestMapping(value = {"/","signIn", "login"}, method = RequestMethod.GET)
    public String index(){
        return "signIn";
    }
}
