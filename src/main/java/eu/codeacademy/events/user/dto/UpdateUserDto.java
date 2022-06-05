package eu.codeacademy.events.user.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class UpdateUserDto {

    private UUID userId;
    private String nickname;
    private String location;
    private String email;
    private String birthday;
    private String password;
    private String phoneNumber;
}
