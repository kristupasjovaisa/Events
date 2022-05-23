package eu.codeacademy.events.user.service;

import eu.codeacademy.events.user.dto.UserDto;
import eu.codeacademy.events.user.entity.UserEntity;
import eu.codeacademy.events.user.mapper.UserMapper;
import eu.codeacademy.events.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

class UserServiceTest {

    private UserRepository userRepository = Mockito.mock(UserRepository.class);

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    @DisplayName("Shoud find User by Id")
    void getUserByUUID() {
        UserService userService = new UserService(userRepository,new UserMapper());
        UserEntity input = UserEntity.builder().
                userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358")).
                nickname("Petras").
                location("Palanga").
                email("petras@gmail.com").
                birthday(Date.valueOf("1994-04-04")).
                password("Labas").
                phoneNumber("867777777").
                description("Vakarelis!!!")
                .build();

        UserDto expected = UserDto.builder().
                userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358")).
                nickname("Petras").
                location("Palanga").
                email("petras@gmail.com").
                birthday("1994-04-04").
                password("Labas").
                phoneNumber("867777777").
                description("Vakarelis!!!")
                .build();

        Mockito.when(userRepository.findByUserId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(input));
        UserDto actual = userService.getUserByUUID(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        Assertions.assertThat(actual.getUserId()).isEqualTo(expected.getUserId());

    }

    @Test
    void getAllUsers() {
    }
}