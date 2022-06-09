package eu.codeacademy.events.event.controller;

import eu.codeacademy.events.event.dto.AddEventDto;
import eu.codeacademy.events.event.dto.EventDto;
import eu.codeacademy.events.event.dto.UpdateEventDto;
import eu.codeacademy.events.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String deleteEvent(@PathVariable UUID id, Model model) {
        eventService.delete(id);
        model.addAttribute("events", eventService.getAllEvents());
        return "events";
    }

    @GetMapping("/update/{id}")
    public String updateEvent(@PathVariable UUID id, Model model) {
        model.addAttribute("event", eventService.getEventByUUID(id));
        return "update-event";
    }

    @PostMapping("/save-update/{id}")
    public String updateEvent(@PathVariable UUID id, UpdateEventDto event, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-event";
        }
        event.setEventId(id);
        eventService.update(event);
        model.addAttribute("events", eventService.getAllEvents());
        return "redirect:/events";
    }

    @GetMapping("/add-event")
    public String addEvent(AddEventDto event, Model model) {
        model.addAttribute("event", event);
        return "add-event";
    }

    @PostMapping("/save-event")
    public String saveEvent(AddEventDto event, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-event";
        }
        eventService.add(event);
        model.addAttribute("events", eventService.getAllEvents());
        return "redirect:/events";
    }
}
