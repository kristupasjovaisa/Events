package eu.codeacademy.events.api.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class UsersResponse {

    @ApiModelProperty(notes = "Users list", required = true, allowEmptyValue = false)
    private List<UserResponse> users;
}