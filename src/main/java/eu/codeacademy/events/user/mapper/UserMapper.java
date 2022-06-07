package eu.codeacademy.events.user.mapper;

import eu.codeacademy.events.user.dto.AddUserDto;
import eu.codeacademy.events.user.dto.UpdateUserDto;
import eu.codeacademy.events.user.dto.UserDto;
import eu.codeacademy.events.user.dto.UserRoleDto;
import eu.codeacademy.events.user.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class UserMapper {

    public UserEntity mapFrom(AddUserDto dto) {
        return UserEntity.builder().
                userId(UUID.randomUUID()).
                nickname(dto.getNickname()).
                city(dto.getCity()).
                email(dto.getEmail()).
                password(dto.getPassword()).
                phoneNumber(dto.getPhoneNumber()).
                build();
    }

    public UserEntity mapFrom(UpdateUserDto dto) {
        return UserEntity.builder().
                userId(dto.getUserId()).
                nickname(dto.getNickname()).
                city(dto.getCity()).
                email(dto.getEmail()).
                password(dto.getPassword()).
                phoneNumber(dto.getPhoneNumber()).
                build();
    }

    public UserDto mapFrom(UserEntity user) {
        return UserDto.builder().
                userId(user.getUserId()).
                nickname(user.getNickname()).
                city(user.getCity()).
                email(user.getEmail()).
                password(user.getPassword()).
                phoneNumber(user.getPhoneNumber()).
                build();
    }

    public UserRoleDto mapUserRoleFrom(UserEntity user) {
        return UserRoleDto.builder()
                .user(UserDto.builder()
                        .nickname(user.getNickname())
                        .city(user.getCity())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .phoneNumber(user.getPhoneNumber())
                        .build()).build();
    }
}
