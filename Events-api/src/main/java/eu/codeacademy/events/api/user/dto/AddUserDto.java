package eu.codeacademy.events.api.user.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddUserDto {

    private String nickname;
    private String city;
    private String email;
    private String password;
    private String phoneNumber;
}
