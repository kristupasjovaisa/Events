package eu.codeacademy.events.security.jwt.dto;

import lombok.Value;

@Value(staticConstructor = "of")
public class LoginResponse {

    String nickname;
    String jwtToken;
    Long jwtTokenExpiresIn;
}
