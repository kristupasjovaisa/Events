package eu.codeacademy.events.event.service;

import eu.codeacademy.events.event.dto.AddEventDto;
import eu.codeacademy.events.event.dto.EventDto;
import eu.codeacademy.events.event.dto.UpdateEventDto;

import java.util.List;
import java.util.UUID;

public interface EventService {

    UUID add(AddEventDto dto);

    String update(UpdateEventDto dto);

    Long remove(Long id);

    List<EventDto> getAll();
}
