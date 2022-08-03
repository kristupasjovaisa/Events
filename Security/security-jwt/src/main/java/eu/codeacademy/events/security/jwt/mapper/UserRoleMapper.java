package eu.codeacademy.events.security.jwt.mapper;

import eu.codeacademy.events.api.user.dto.UserResponse;
import eu.codeacademy.events.api.user.dto.UserRoleDto;
import eu.codeacademy.events.jpa.authority.entity.Authority;
import eu.codeacademy.events.jpa.user.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class UserRoleMapper {

    public UserRoleDto mapUserRoleFrom(User user) {
        return UserRoleDto.builder()
                .user(UserResponse.builder()
                        .userId(user.getUserId())
                        .name(user.getName())
                        .city(user.getCity())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .phoneNumber(user.getPhoneNumber())
                        .build())
                .roles(user.getAuthorities().stream()
                        .map(getAuthority())
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toUnmodifiableSet())
                )
                .build();
    }

    private Function<Authority, String> getAuthority() {
        return authority -> "ROLE_" + authority.getName();
    }
}
