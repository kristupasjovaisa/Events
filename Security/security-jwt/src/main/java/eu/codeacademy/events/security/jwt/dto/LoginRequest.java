package eu.codeacademy.events.security.jwt.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;
}
