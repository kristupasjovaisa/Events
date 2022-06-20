package eu.codeacademy.events.api.utils;

import eu.codeacademy.events.api.user.dto.UserDto;
import lombok.Builder;

import java.util.UUID;

@Builder
public final class SecurityUtils {

    private SecurityUtils() {
    }

    // FIXME:
    public static UserDto getUser() {
        return UserDto.builder()
                .userId(UUID.randomUUID())
                .nickname("Laikinas")
                .phoneNumber("123456789")
                .password("password")
                .email("a@a.com")
                .city("kaunas")
                .build();
    }
}
