package eu.codeacademy.events.user.service;

import eu.codeacademy.events.user.dto.AddUserDto;
import eu.codeacademy.events.user.dto.UpdateUserDto;
import eu.codeacademy.events.user.dto.UserDto;
import eu.codeacademy.events.user.entity.UserEntity;
import eu.codeacademy.events.user.mapper.UserMapper;
import eu.codeacademy.events.user.repository.UserRepository;
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

import static org.mockito.Mockito.verify;

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

        UserEntity user = UserEntity
                .builder()
                .userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        AddUserDto input = AddUserDto.builder().build();
        UserDto userDto = UserDto
                .builder()
                .userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        Mockito.when(userMapper.mapTo(input)).thenReturn(user);
        Mockito.when(userMapper.mapTo(user)).thenReturn(userDto);

        Mockito.when(userRepository.save(userMapper.mapTo(input))).thenReturn(user);

        UserDto actual = userService.add(input);

        Assertions.assertThat(actual.getUserId()).isEqualTo(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
    }

    @Test
    @DisplayName("Shoud update User by id")
    void update() {

        UserEntity user = UserEntity
                .builder()
                .userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        UserEntity updatedUser = UserEntity
                .builder()
                .userId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .build();

        UpdateUserDto updateUserDto = UpdateUserDto.builder()
                .userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        UserDto updatedUserDto = UserDto
                .builder()
                .userId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .build();

        Mockito.when(userRepository.findByUserId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(user));
        Mockito.when(userMapper.mapTo(updateUserDto)).thenReturn(user);
        Mockito.when(userRepository.save(user)).thenReturn(updatedUser);
        Mockito.when(userMapper.mapTo(updatedUser)).thenReturn(updatedUserDto);
        UserDto actual = userService.update(updateUserDto);
        Assertions.assertThat(actual.getUserId()).isEqualTo(UUID.fromString("00000000-0000-0000-0000-000000000000"));
    }

    @Test
    @DisplayName("Shoud delete User by Id")
    void delete() {

        UserEntity user = UserEntity.builder()
                .id(1l)
                .build();
        Mockito.when(userRepository.findByUserId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(user));
        boolean actual = userService.delete(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        verify(userRepository, Mockito.times(1)).deleteById(1l);
        Assertions.assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("Shoud find User by Id")
    void getUserByUUID() {

        UserEntity user = UserEntity.builder().
                userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        UserDto userDto = UserDto.builder().
                userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();
        Mockito.when(userRepository.findByUserId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(user));
        Mockito.when(userMapper.mapTo(user)).thenReturn(userDto);
        UserDto actual = userService.getUserByUUID(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        Assertions.assertThat(actual.getUserId()).isEqualTo(user.getUserId());
    }

    @Test
    void getAllUsers() {

        List<UserEntity> list = new ArrayList<>();
        UserEntity user1 = UserEntity.builder().userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358")).
                build();
        list.add(user1);

        UserDto userDto = UserDto.builder().userId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        Mockito.when(userRepository.findAll()).thenReturn(list);
        Mockito.when(userMapper.mapTo(user1)).thenReturn(userDto);

        List<UserDto> actual = userService.getAllUsers();
        Assertions.assertThat(actual.get(0).getUserId()).isEqualTo(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        Assertions.assertThat(actual.size()).isEqualTo(1);
    }
}