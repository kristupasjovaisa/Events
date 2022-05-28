package eu.codeacademy.events.event.controller;

import eu.codeacademy.events.event.dto.EventDto;
import eu.codeacademy.events.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;


    @GetMapping("/events")
    public String findAllEvents(Model model){
        List<EventDto> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "events";
    }
}
