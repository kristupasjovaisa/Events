package eu.codeacademy.events.user.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddUserDto {

    private String nickname;
    private String location;
    private String email;
    private String birthday;
    private String password;
    private String phoneNumber;
    private String description;
}
