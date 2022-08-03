package eu.codeacademy.events.security.jwt.dto;

import lombok.Value;

@Value(staticConstructor = "of")
public class LoginResponse {

    String name;
    String email;
    String jwtToken;
    Long jwtTokenExpiresIn;
}
