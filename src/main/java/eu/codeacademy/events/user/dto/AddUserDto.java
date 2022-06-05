package eu.codeacademy.events.user.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddUserDto {

    private String nickname;
    private String city;
    private String email;
    private String password;
    private String phoneNumber;
}
