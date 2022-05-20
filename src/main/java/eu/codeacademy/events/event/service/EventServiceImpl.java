package eu.codeacademy.events.event.service;

import eu.codeacademy.events.event.dto.AddEventDto;
import eu.codeacademy.events.event.dto.EventDto;
import eu.codeacademy.events.event.dto.UpdateEventDto;
import eu.codeacademy.events.event.mapper.EventMapper;
import eu.codeacademy.events.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper mapper;

    @Override
    public UUID add(AddEventDto dto) {
        return eventRepository.save(mapper.mapTo(dto)).getEventId();
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
