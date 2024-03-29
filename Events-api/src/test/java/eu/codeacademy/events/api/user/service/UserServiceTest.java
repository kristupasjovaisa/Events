package eu.codeacademy.events.api.user.service;

import eu.codeacademy.events.api.user.dto.AddUserRequest;
import eu.codeacademy.events.api.user.dto.UpdateUserRequest;
import eu.codeacademy.events.api.user.dto.UserResponse;
import eu.codeacademy.events.api.user.mapper.UserMapper;
import eu.codeacademy.events.jpa.user.entity.User;
import eu.codeacademy.events.jpa.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserMapper userMapper;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Shoud add Users")
    void add() {

        User user = User
                .builder()
                .userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        AddUserRequest input = AddUserRequest.builder().build();
        UserResponse userDto = UserResponse
                .builder()
                .userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        Mockito.when(userMapper.mapFrom(input)).thenReturn(user);
        Mockito.when(userMapper.mapFrom(user)).thenReturn(userDto);

        Mockito.when(userRepository.save(userMapper.mapFrom(input))).thenReturn(user);

        UserResponse actual = userService.add(input);

        Assertions.assertThat(actual.getUserId()).isEqualTo(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
    }

    @Test
    @DisplayName("Shoud update User by id")
    void update() {

        User user = User
                .builder()
                .userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        User updatedUser = User
                .builder()
                .userId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .build();

        UpdateUserRequest updateUserDto = UpdateUserRequest.builder()
                .userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        UserResponse updatedUserDto = UserResponse
                .builder()
                .userId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .build();

        Mockito.when(userRepository.findByUserId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(user));
        Mockito.when(userMapper.mapFrom(updateUserDto)).thenReturn(user);
        Mockito.when(userRepository.save(user)).thenReturn(updatedUser);
        Mockito.when(userMapper.mapFrom(updatedUser)).thenReturn(updatedUserDto);
        UserResponse actual = userService.update(updateUserDto);
        Assertions.assertThat(actual.getUserId()).isEqualTo(UUID.fromString("00000000-0000-0000-0000-000000000000"));
    }

    @Test
    @DisplayName("Shoud delete User by Id")
    void delete() {

        User user = User.builder()
                .id(1l)
                .build();
        Mockito.when(userRepository.findByUserId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(user));
        boolean actual = userService.delete(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        Mockito.verify(userRepository, Mockito.times(1)).deleteById(1l);
        Assertions.assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("Shoud find User by Id")
    void getUserByUUID() {

        User user = User.builder().
                userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        UserResponse userDto = UserResponse.builder().
                userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();
        Mockito.when(userRepository.findByUserId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(user));
        Mockito.when(userMapper.mapFrom(user)).thenReturn(userDto);
        UserResponse actual = userService.getUserByUUID(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        Assertions.assertThat(actual.getUserId()).isEqualTo(user.getUserId());
    }

    @Test
    void getAllUsers() {

        List<User> list = new ArrayList<>();
        User user1 = User.builder().userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358")).
                build();
        list.add(user1);

        UserResponse userDto = UserResponse.builder().userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        Mockito.when(userRepository.findAll()).thenReturn(list);
        Mockito.when(userMapper.mapFrom(user1)).thenReturn(userDto);

        List<UserResponse> actual = userService.getAllUsers();
        Assertions.assertThat(actual.get(0).getUserId()).isEqualTo(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        Assertions.assertThat(actual.size()).isEqualTo(1);
    }
}