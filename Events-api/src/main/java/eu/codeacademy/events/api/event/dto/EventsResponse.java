package eu.codeacademy.events.api.event.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class EventsResponse {

    @ApiModelProperty(notes = "Events list", required = true, allowEmptyValue = false)
    private List<EventDto> events;
}
