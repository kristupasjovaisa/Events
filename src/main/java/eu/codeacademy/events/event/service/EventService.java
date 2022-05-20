package eu.codeacademy.events.event.service;

import eu.codeacademy.events.event.dto.AddEventDto;
import eu.codeacademy.events.event.dto.EventDto;
import eu.codeacademy.events.event.dto.UpdateEventDto;

import java.util.List;

public interface EventService {

    boolean add(AddEventDto dto);

    String update(UpdateEventDto dto);

    Long remove(Long id);

    List<EventDto> getAll();
}
