package eu.codeacademy.events.api.user.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class UpdateUserDto {

    private UUID userId;
    private String nickname;
    private String city;
    private String email;
    private String password;
    private String phoneNumber;
}
