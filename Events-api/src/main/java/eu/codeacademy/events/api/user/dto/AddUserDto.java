package eu.codeacademy.events.api.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AddUserDto {

    private String nickname;
    private String city;
    private String email;
    private String password;
    private String phoneNumber;
}
