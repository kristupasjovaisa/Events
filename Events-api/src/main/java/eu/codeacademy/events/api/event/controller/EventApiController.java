package eu.codeacademy.events.api.event.controller;

import eu.codeacademy.events.api.event.dto.AddEventDto;
import eu.codeacademy.events.api.event.dto.EventsResponse;
import eu.codeacademy.events.api.event.dto.UpdateEventDto;
import eu.codeacademy.events.api.event.service.EventService;
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
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping(EventApiController.EVENTS_ROOT_PATH)
@RestController
@Api(tags = "Event Controller")
public class EventApiController {

    public static final String UUID_PATH = "/{uuid}";
    public static final String EVENTS_ROOT_PATH = "/events";
    private final EventService eventService;

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

    @GetMapping(
            path = UUID_PATH,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Get one event by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Event returned successfully"),
            @ApiResponse(code = 401, message = "User must be authorized"),
            @ApiResponse(code = 403, message = "User is not granted to get event")
    })
    public EventsResponse getEventByUUID(@PathVariable("uuid") UUID id) {
        return EventsResponse.builder()
                .events(List.of(eventService.getEventByUUID(id))).build();
    }

    @DeleteMapping(path = UUID_PATH)
    public void deleteEventById(@PathVariable("uuid") UUID id) {
        eventService.delete(id);
    }

    @PostMapping
    public ResponseEntity<Void> createEvent(@Valid @RequestBody AddEventDto dto) {
        eventService.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateEvent(@Valid @RequestBody UpdateEventDto dto) {
        if (eventService.update(dto) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.notFound().build();
    }
}
