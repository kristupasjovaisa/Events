package eu.codeacademy.events.security.jwt.contoller;

import eu.codeacademy.events.api.user.dto.UserRoleDto;
import eu.codeacademy.events.commons.swagger.annotation.OpenApi;
import eu.codeacademy.events.security.jwt.dto.LoginRequest;
import eu.codeacademy.events.security.jwt.dto.LoginResponse;
import eu.codeacademy.events.security.jwt.service.JwtProvider;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/login")
@Api(tags = "Login Controller")
@OpenApi
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest authRequest) throws Exception {
        return Optional.of(authenticate(authRequest.getEmail(), authRequest.getPassword()))
                .map(auth -> (UserRoleDto) auth.getPrincipal())
                .map(principal -> ok(LoginResponse.of(
                        principal.getUserName(),
                        authRequest.getEmail(),
                        jwtProvider.getToken(principal),
                        jwtProvider.getExpiresInSeconds()
                )))
                .orElseThrow(() -> new BadCredentialsException("Authentication failed"));
    }

    private Authentication authenticate(String email, String password) throws Exception {
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
