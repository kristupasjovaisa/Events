package eu.codeacademy.events.api.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class UserNotFoundException extends RuntimeException {
    private final UUID userId;
}
