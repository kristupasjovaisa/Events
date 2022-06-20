package eu.codeacademy.events.api.event.controller;

import eu.codeacademy.events.api.event.dto.EventDto;
import eu.codeacademy.events.api.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/events")
@RestController
public class EventApiController {

    private final EventService eventService;

    @ResponseBody
    @GetMapping()
    public List<EventDto> getEvents(){
        return eventService.getAllEvents();
    }
}
