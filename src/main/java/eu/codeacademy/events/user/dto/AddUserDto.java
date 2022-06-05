package eu.codeacademy.events.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class AddUserDto {

    private String nickname;
    private String location;
    private String email;
    private String password;
    private String phoneNumber;
}
