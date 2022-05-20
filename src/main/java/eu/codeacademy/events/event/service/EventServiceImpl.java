package eu.codeacademy.events.event.service;

import eu.codeacademy.events.event.dto.AddEventDto;
import eu.codeacademy.events.event.dto.EventDto;
import eu.codeacademy.events.event.dto.UpdateEventDto;
import eu.codeacademy.events.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public boolean add(AddEventDto dto) {
        return false;
    }

    @Override
    public String update(UpdateEventDto dto) {
        return null;
    }

    @Override
    public Long remove(Long id) {
        return null;
    }

    @Override
    public List<EventDto> getAll() {
        return null;
    }
}
