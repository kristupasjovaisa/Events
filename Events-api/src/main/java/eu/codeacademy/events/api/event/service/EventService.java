package eu.codeacademy.events.api.event.service;

import eu.codeacademy.events.api.event.dto.AddEventRequest;
import eu.codeacademy.events.api.event.dto.EventResponse;
import eu.codeacademy.events.api.event.dto.UpdateEventRequest;
import eu.codeacademy.events.api.event.exception.EventNotFoundException;
import eu.codeacademy.events.api.event.mapper.EventMapper;
import eu.codeacademy.events.api.utils.SecurityUtils;
import eu.codeacademy.events.jpa.event.entity.Event;
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

    public EventResponse add(AddEventRequest dto) {
        var event = mapper.mapFrom(dto);
        var owner = userRepository.findByUserId(SecurityUtils.getUser().getUserId());
        if (owner.isPresent()) {
            event.setOwner(owner.get());
        }
        return mapper.mapFrom(eventRepository.save(event));
    }

    @Transactional
    public EventResponse update(UpdateEventRequest dto) {
        Optional<Event> eventOptional = eventRepository.findByEventId(dto.getEventId());
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
        Optional<Event> event = eventRepository.findByEventId(id);
        if (event.isPresent()) {
            event.ifPresent(value -> eventRepository.deleteById(value.getId()));
            return true;
        }
        return false;
    }

    public EventResponse getEventByUUID(UUID id) {
        return eventRepository.findByEventId(id).map(event -> mapper.mapFrom(event))
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public List<EventResponse> getAllEvents() {
        var list = eventRepository.findAll();
        if (list != null) {
            return list.stream()
                    .map(mapper::mapFrom)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
