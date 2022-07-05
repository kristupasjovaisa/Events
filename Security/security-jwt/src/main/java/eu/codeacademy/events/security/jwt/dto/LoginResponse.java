package eu.codeacademy.events.security.jwt.dto;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;
@Getter
public class LoginResponse {

    private final String username;

    private final Set<String> roles;

    public LoginResponse(UserRoleDto userRoleDto) {
        this.username = userRoleDto.getUsername();
        this.roles = userRoleDto.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
    }
}
