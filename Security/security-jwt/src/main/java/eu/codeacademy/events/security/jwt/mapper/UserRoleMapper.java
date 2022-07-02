package eu.codeacademy.events.security.jwt.mapper;

import eu.codeacademy.events.api.user.dto.UserDto;
import eu.codeacademy.events.jpa.authority.entity.Authority;
import eu.codeacademy.events.jpa.user.entity.UserEntity;
import eu.codeacademy.events.security.jwt.dto.UserRoleDto;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class UserRoleMapper {

    public UserRoleDto mapUserRoleFrom(UserEntity user) {
        return UserRoleDto.builder()
                .user(UserDto.builder()
                        .userId(user.getUserId())
                        .nickname(user.getNickname())
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
        return authority -> "ROLE_" + authority.getNickname();
    }
}