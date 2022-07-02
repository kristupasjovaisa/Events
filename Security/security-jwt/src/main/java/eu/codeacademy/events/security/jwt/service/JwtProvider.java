package eu.codeacademy.events.security.jwt.service;

import eu.codeacademy.events.security.jwt.dto.UserRoleDto;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    public String getToken(UserRoleDto principal) {
        return "My token: " + principal.getUsername();
    }
}
