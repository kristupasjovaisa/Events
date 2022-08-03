package eu.codeacademy.events.api.user.mapper;

import eu.codeacademy.events.api.user.dto.AddUserRequest;
import eu.codeacademy.events.api.user.dto.UpdateUserRequest;
import eu.codeacademy.events.api.user.dto.UserResponse;
import eu.codeacademy.events.jpa.authority.entity.Authority;
import eu.codeacademy.events.jpa.authority.repository.AuthorityRepository;
import eu.codeacademy.events.jpa.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {
    final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    private final AuthorityRepository authorityRepository;

    public UserEntity mapFrom(AddUserRequest dto) {
        Set<Authority> authorities = authorityRepository.findAll()
                .stream().filter(authority -> authority.getName().equals("USER"))
                .collect(Collectors.toSet());

        return UserEntity.builder().
                userId(UUID.randomUUID()).
                name(dto.getName()).
                lastName(dto.getLastName()).
                city(dto.getCity()).
                email(dto.getEmail()).
                password(passwordEncoder.encode(dto.getPassword())).
                phoneNumber(dto.getPhoneNumber()).
                authorities(authorities).
                build();
    }

    public UserEntity mapFrom(UpdateUserRequest dto) {
        return UserEntity.builder().
                userId(dto.getUserId()).
                name(dto.getName()).
                lastName(dto.getLastName()).
                city(dto.getCity()).
                email(dto.getEmail()).
                password(dto.getPassword()).
                phoneNumber(dto.getPhoneNumber()).
                build();
    }

    public UserResponse mapFrom(UserEntity user) {
        return UserResponse.builder().
                userId(user.getUserId()).
                name(user.getName()).
                lastName(user.getLastName()).
                city(user.getCity()).
                email(user.getEmail()).
                password(user.getPassword()).
                phoneNumber(user.getPhoneNumber()).
                build();
    }
}
