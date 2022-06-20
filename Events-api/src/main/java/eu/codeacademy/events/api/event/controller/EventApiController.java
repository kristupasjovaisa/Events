package eu.codeacademy.events.api.event.controller;

import eu.codeacademy.events.api.event.dto.EventDto;
import eu.codeacademy.events.api.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class EventApiController {

    private final EventService eventService;

    @ResponseBody
    @GetMapping(value = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EventDto> getEvents(){
        return eventService.getAllEvents();
    }
}
