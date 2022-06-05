package eu.codeacademy.events.index.controller;

import eu.codeacademy.events.user.dto.AddUserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String signUpForm(Model model, AddUserDto user){
        model.addAttribute("user", user);
        return "signup-form";
    }
}
