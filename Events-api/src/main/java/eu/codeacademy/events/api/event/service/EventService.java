package eu.codeacademy.events.api.event.service;

import eu.codeacademy.events.api.event.dto.AddEventDto;
import eu.codeacademy.events.api.event.dto.EventDto;
import eu.codeacademy.events.api.event.dto.UpdateEventDto;
import eu.codeacademy.events.api.event.exception.EventNotFoundException;
import eu.codeacademy.events.api.event.mapper.EventMapper;
import eu.codeacademy.events.api.utils.SecurityUtils;
import eu.codeacademy.events.jpa.event.entity.EventEntity;
import eu.codeacademy.events.jpa.event.repository.EventRepository;
import eu.codeacademy.events.jpa.user.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final EventMapper mapper;

    public EventDto add(AddEventDto dto) {
        var event = mapper.mapFrom(dto);
        var owner = userRepository.findByUserId(SecurityUtils.getUser().getUserId());
        if (owner.isPresent()) {
            event.setOwner(owner.get());
        }
        return mapper.mapFrom(eventRepository.save(event));
    }

    @Transactional
    public EventDto update(UpdateEventDto dto) {
        Optional<EventEntity> eventOptional = eventRepository.findByEventId(dto.getEventId());
        if (eventOptional.isPresent()) {
            var owner = userRepository.findByUserId(SecurityUtils.getUser().getUserId());
            var event = mapper.mapFrom(dto, eventOptional.get().getId());
            if (owner.isPresent()) {
                event.setOwner(owner.get());
            }
            return mapper.mapFrom(eventRepository.save(event));
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
        return eventRepository.findByEventId(id).map(event -> mapper.mapFrom(event))
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public List<EventDto> getAllEvents() {
        var list = eventRepository.findAll();
        if (list != null) {
            return list.stream()
                    .map(mapper::mapFrom)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
