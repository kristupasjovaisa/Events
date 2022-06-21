package eu.codeacademy.events.api.event.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class EventsResponse {

    private List<EventDto> events;
}
