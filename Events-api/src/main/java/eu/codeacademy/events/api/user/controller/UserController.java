package eu.codeacademy.events.api.user.controller;

import eu.codeacademy.events.api.user.dto.AddUserDto;
import eu.codeacademy.events.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String signUpForm(Model model, AddUserDto user) {
        model.addAttribute("user", user);
        return "signup-form";
    }

    @PostMapping("/process-register")
    public String processRegistration(AddUserDto user, BindingResult result){
        if (result.hasErrors()){
            return "signup-form";
        }
        userService.add(user);
        return "register-success";
    }
}
