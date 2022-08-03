package eu.codeacademy.events.api.event.controller;

import eu.codeacademy.events.api.event.dto.AddEventRequest;
import eu.codeacademy.events.api.event.dto.EventResponse;
import eu.codeacademy.events.api.event.dto.UpdateEventRequest;
import eu.codeacademy.events.api.event.service.EventService;
import eu.codeacademy.events.commons.swagger.annotation.OpenApi;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping(EventApiController.EVENTS_ROOT_PATH)
@RestController
@Api(tags = "Event Controller")
@OpenApi
@CrossOrigin
public class EventApiController {

    public static final String UUID_PATH = "/{uuid}";
    public static final String EVENTS_ROOT_PATH = "/events";
    private final EventService eventService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Get all events",
            notes = "Get all events from db, and any other information could be here")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Event returned successfully"),
            @ApiResponse(code = 401, message = "User must be authorized"),
            @ApiResponse(code = 403, message = "User is not granted to get events")
    })
    public List<EventResponse> getEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping(
            path = UUID_PATH,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Get one event by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Event returned successfully"),
            @ApiResponse(code = 401, message = "User must be authorized"),
            @ApiResponse(code = 403, message = "User is not granted to get event")
    })
    public EventResponse getEventByUUID(@PathVariable("uuid") UUID id) {
        return eventService.getEventByUUID(id);
    }

    @GetMapping(path = "/page")
    @ApiOperation(value = "Get all event by page and size")
    public Page<EventResponse> eventsPaginated(
            @ApiParam(
                    name = "page",
                    type = "int",
                    value = "Number of page",
                    example = "1",
                    required = true)
            @RequestParam("page") int page,

            @ApiParam(
                    name = "size",
                    type = "int",
                    value = "Content size in page",
                    example = "1",
                    required = true)
            @RequestParam("size") int size) {
        return eventService.getEventPaginated(PageRequest.of(page, size));
    }

    @DeleteMapping(path = UUID_PATH)
    @ApiOperation(value = "Delete event", httpMethod = "DELETE")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteEventById(@PathVariable("uuid") UUID id) {
        eventService.delete(id);
    }

    @PostMapping
    @ApiOperation(value = "Create event", httpMethod = "POST")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> createEvent(@Valid @RequestBody AddEventRequest dto) {
        eventService.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @ApiOperation(value = "Update event", httpMethod = "PUT")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> updateEvent(@Valid @RequestBody UpdateEventRequest dto) {
        if (eventService.update(dto) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.notFound().build();
    }
}
