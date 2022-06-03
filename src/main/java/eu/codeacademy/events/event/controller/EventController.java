package eu.codeacademy.events.event.controller;

import eu.codeacademy.events.event.dto.EventDto;
import eu.codeacademy.events.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;


    @GetMapping("/events")
    public String findAllEvents(Model model) {
        List<EventDto> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "events";
    }

    @GetMapping("/event/{id}")
    public String findEvent(@PathVariable UUID id, Model model) {
        EventDto event = eventService.getEventByUUID(id);
        model.addAttribute("event", event);
        return "list-event";
    }

    @GetMapping("delete/{id}")
    public String deleteEvent(@PathVariable UUID id, Model model){
        eventService.delete(id);
        model.addAttribute("events", eventService.getAllEvents());
        return "events";
    }

    @GetMapping("/update/{id}")
    public String updateEvent(@PathVariable UUID id, Model model){
        EventDto event = eventService.getEventByUUID(id);
        model.addAttribute("event",event);
        return "update-event";
    }
}
