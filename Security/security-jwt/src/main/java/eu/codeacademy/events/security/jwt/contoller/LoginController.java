package eu.codeacademy.events.security.jwt.contoller;

import eu.codeacademy.events.commons.swagger.annotation.OpenApi;
import eu.codeacademy.events.security.jwt.dto.LoginResponse;
import eu.codeacademy.events.security.jwt.dto.UserRoleDto;
import io.swagger.annotations.Api;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Api(tags = "Login Controller")
@OpenApi
public class LoginController {

    @PostMapping
    public LoginResponse login(@AuthenticationPrincipal UserRoleDto userRoleDto){
        return new LoginResponse(userRoleDto);
    }
}
