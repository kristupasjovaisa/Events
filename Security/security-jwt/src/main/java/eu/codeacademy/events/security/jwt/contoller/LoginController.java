package eu.codeacademy.events.security.jwt.contoller;

import eu.codeacademy.events.security.jwt.dto.LoginResponse;
import eu.codeacademy.events.security.jwt.dto.UserRoleDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public LoginResponse login(@AuthenticationPrincipal UserRoleDto userRoleDto){
        return new LoginResponse(userRoleDto);
    }
}
