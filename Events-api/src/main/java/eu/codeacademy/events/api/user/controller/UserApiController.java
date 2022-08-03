package eu.codeacademy.events.api.user.controller;

import eu.codeacademy.events.api.user.dto.AddUserRequest;
import eu.codeacademy.events.api.user.dto.UpdateUserRequest;
import eu.codeacademy.events.api.user.dto.UsersResponse;
import eu.codeacademy.events.api.user.service.UserService;
import eu.codeacademy.events.commons.swagger.annotation.OpenApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(UserApiController.USER_ROOT_PATH)
@Api(tags = "User Controller")
@OpenApi
@CrossOrigin
public class UserApiController {

    public static final String USER_ROOT_PATH = "/user";
    public static final String UUID_PATH = "/{uuid}";
    private final UserService userService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Get all users",
            notes = "Get all users from db, and any other information could be here")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User returned successfully"),
            @ApiResponse(code = 401, message = "User must be authorized"),
            @ApiResponse(code = 403, message = "User is not granted to get user")
    })
    public UsersResponse getUsers() {
        return UsersResponse.builder().users(userService.getAllUsers()).build();
    }


    @PostMapping
    @ApiOperation(value = "Create user", httpMethod = "POST")
    public ResponseEntity<Void> createUser(@Valid @RequestBody AddUserRequest dto) {
        userService.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @ApiOperation(value = "Update user", httpMethod = "PUT")
    public ResponseEntity<Void> updateUser(@Valid @RequestBody UpdateUserRequest dto) {
        if (userService.update(dto) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = UUID_PATH)
    @ApiOperation(value = "Delete user", httpMethod = "DELETE")
    public void deleteUserById(@PathVariable("uuid") UUID id) {
        userService.delete(id);
    }
}