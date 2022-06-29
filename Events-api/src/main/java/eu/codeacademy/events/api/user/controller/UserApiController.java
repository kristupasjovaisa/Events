package eu.codeacademy.events.api.user.controller;

import eu.codeacademy.events.api.user.dto.AddUserDto;
import eu.codeacademy.events.api.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(UserApiController.USER_ROOT_PATH)
@Api(tags = "User Controller")
public class UserApiController {

    public static final String USER_ROOT_PATH = "/register";
    private final UserService userService;


    @PostMapping
    @ApiOperation(value = "Create user", httpMethod = "POST")
    public ResponseEntity<Void> createUser(@Valid @RequestBody AddUserDto dto) {
        userService.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}