package eu.codeacademy.events.api.utils;

import eu.codeacademy.events.api.user.dto.UserDto;
import eu.codeacademy.events.api.user.dto.UserRoleDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtils {

    private SecurityUtils() {
    }

    public static UserDto getUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            UserRoleDto userRoleDto = (UserRoleDto) authentication.getPrincipal();
            return userRoleDto.getUser();
        }
        return null;
    }
}