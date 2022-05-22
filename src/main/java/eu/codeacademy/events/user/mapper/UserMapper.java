package eu.codeacademy.events.user.mapper;

import eu.codeacademy.events.user.dto.AddUserDto;
import eu.codeacademy.events.user.dto.UpdateUserDto;
import eu.codeacademy.events.user.dto.UserDto;
import eu.codeacademy.events.user.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class UserMapper {

    public UserEntity mapTo(AddUserDto dto) {
        return UserEntity.builder().
                userId(dto.getUserId()).
                nickname(dto.getNickname()).
                location(dto.getLocation()).
                email(dto.getEmail()).
                birthday(Date.valueOf(dto.getBirthday())).
                password(dto.getPassword()).
                phoneNumber(dto.getPhoneNumber()).
                description(dto.getDescription())
                .build();
    }

    public UserEntity mapTo(UpdateUserDto dto) {
        return UserEntity.builder().
                userId(dto.getUserId()).
                nickname(dto.getNickname()).
                location(dto.getLocation()).
                email(dto.getEmail()).
                birthday(Date.valueOf(dto.getBirthday())).
                password(dto.getPassword()).
                phoneNumber(dto.getPhoneNumber()).
                description(dto.getDescription())
                .build();
    }

    public UserDto mapTo(UserEntity user) {
        return UserDto.builder().
                userId(user.getUserId()).
                nickname(user.getNickname()).
                location(user.getLocation()).
                email(user.getEmail()).
                birthday(String.valueOf(user.getBirthday())).
                password(user.getPassword()).
                phoneNumber(user.getPhoneNumber()).
                description(user.getDescription())
                .build();
    }
}
