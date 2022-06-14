package eu.codeacademy.events.user.service;

import eu.codeacademy.events.user.dto.AddUserDto;
import eu.codeacademy.events.user.dto.UpdateUserDto;
import eu.codeacademy.events.user.dto.UserDto;
import eu.codeacademy.events.user.entity.UserEntity;
import eu.codeacademy.events.user.exception.UserNotFoundException;
import eu.codeacademy.events.user.mapper.UserMapper;
import eu.codeacademy.events.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserDto add(AddUserDto dto) {
        return mapper.mapFrom(userRepository.save(mapper.mapFrom(dto)));
    }

    @Transactional
    public UserDto update(UpdateUserDto dto) {
        Optional<UserEntity> userOptional = userRepository.findByUserId(dto.getUserId());
        if (userOptional.isPresent()) {
            return mapper.mapFrom(userRepository.save(mapper.mapFrom(dto)));
        }
        return null;
    }

    @Transactional
    public boolean delete(UUID id) {
        Optional<UserEntity> user = userRepository.findByUserId(id);
        if (user.isPresent()) {
            user.ifPresent(value -> userRepository.deleteById(value.getId()));
            return true;
        }
        return false;
    }

    public UserDto getUserByUUID(UUID id) {
        return userRepository.findByUserId(id).map(mapper::mapFrom)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<UserDto> getAllUsers() {
        var list = userRepository.findAll();
        if (list != null) {
            return list.stream()
                    .map(mapper::mapFrom)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
