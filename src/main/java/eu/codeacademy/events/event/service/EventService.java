package eu.codeacademy.events.event.service;

import eu.codeacademy.events.event.dto.AddEventDto;
import eu.codeacademy.events.event.dto.EventDto;
import eu.codeacademy.events.event.dto.UpdateEventDto;
import eu.codeacademy.events.event.entity.EventEntity;
import eu.codeacademy.events.event.exception.EventNotFoundException;
import eu.codeacademy.events.event.mapper.EventMapper;
import eu.codeacademy.events.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper mapper;

    public EventDto add(AddEventDto dto) {
        return mapper.mapTo(eventRepository.save(mapper.mapTo(dto)));
    }

    @Transactional
    public EventDto update(UpdateEventDto dto) {
        Optional<EventEntity> eventOptional = eventRepository.findByEventId(dto.getEventId());
        if (eventOptional.isPresent()) {
            return mapper.mapTo(eventRepository.save(mapper.mapTo(dto,eventOptional.get().getId())));
        }
        return null;
    }

    @Transactional
    public boolean delete(UUID id) {
        Optional<EventEntity> event = eventRepository.findByEventId(id);
        if (event.isPresent()) {
            event.ifPresent(value -> eventRepository.deleteById(value.getId()));
            return true;
        }
        return false;
    }

    public EventDto getEventByUUID(UUID id) {
        return eventRepository.findByEventId(id).map(mapper::mapTo)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public List<EventDto> getAllEvents() {
        var list = eventRepository.findAll();
        if (list != null) {
            return list.stream()
                    .map(mapper::mapTo)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
