package eu.codeacademy.events.security.jwt.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String nickname;
    private String password;
}
