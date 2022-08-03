package eu.codeacademy.events.api.user.service;

import eu.codeacademy.events.api.user.dto.AddUserRequest;
import eu.codeacademy.events.api.user.dto.UpdateUserRequest;
import eu.codeacademy.events.api.user.dto.UserResponse;
import eu.codeacademy.events.api.user.exception.UserNotFoundException;
import eu.codeacademy.events.api.user.mapper.UserMapper;
import eu.codeacademy.events.jpa.user.entity.User;
import eu.codeacademy.events.jpa.user.repository.UserRepository;
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

    public UserResponse add(AddUserRequest dto) {
        return mapper.mapFrom(userRepository.save(mapper.mapFrom(dto)));
    }

    @Transactional
    public UserResponse update(UpdateUserRequest dto) {
        Optional<User> userOptional = userRepository.findByUserId(dto.getUserId());
        if (userOptional.isPresent()) {
            return mapper.mapFrom(userRepository.save(mapper.mapFrom(dto)));
        }
        return null;
    }

    @Transactional
    public boolean delete(UUID id) {
        Optional<User> user = userRepository.findByUserId(id);
        if (user.isPresent()) {
            user.ifPresent(value -> userRepository.deleteById(value.getId()));
            return true;
        }
        return false;
    }

    public UserResponse getUserByUUID(UUID id) {
        return userRepository.findByUserId(id).map(mapper::mapFrom)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<UserResponse> getAllUsers() {
        var list = userRepository.findAll();
        if (list != null) {
            return list.stream()
                    .map(mapper::mapFrom)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
