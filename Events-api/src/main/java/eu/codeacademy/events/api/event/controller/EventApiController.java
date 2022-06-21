package eu.codeacademy.events.api.event.controller;

import eu.codeacademy.events.api.event.dto.EventsResponse;
import eu.codeacademy.events.api.event.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/events")
@RestController
@Api(tags = "Event Controller")
public class EventApiController {

    private final EventService eventService;

    @ResponseBody
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(
            value = "Get all events",
            notes = "Get all events from db, and any other information could be here")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Event returned successfully"),
            @ApiResponse(code = 401, message = "User must be authorized"),
            @ApiResponse(code = 403, message = "User is not granted to get events")
    })
    public EventsResponse getEvents() {
        return EventsResponse.builder().events(eventService.getAllEvents()).build();
    }
}
