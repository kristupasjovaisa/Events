package eu.codeacademy.events.api.event.mapper;

import eu.codeacademy.events.api.event.dto.AddEventRequest;
import eu.codeacademy.events.api.event.dto.EventResponse;
import eu.codeacademy.events.api.event.dto.UpdateEventRequest;
import eu.codeacademy.events.jpa.event.entity.EventEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.UUID;

@Component
public class EventMapper {

    public EventEntity mapFrom(AddEventRequest dto) {
        return EventEntity.builder().
                eventId(UUID.randomUUID()).
                name(dto.getName()).
                location(dto.getLocation()).
                category(dto.getCategory()).
                price(dto.getPrice()).
                startEventDateTime(Timestamp.valueOf(dto.getStartEventDateTime())).
                endEventDateTime(Timestamp.valueOf(dto.getEndEventDateTime())).
                description(dto.getDescription())
                .build();
    }

    public EventEntity mapFrom(UpdateEventRequest dto, Long id) {
        return EventEntity.builder().
                id(id).
                eventId(dto.getEventId()).
                name(dto.getName()).
                location(dto.getLocation()).
                category(dto.getCategory()).
                price(dto.getPrice()).
                startEventDateTime(Timestamp.valueOf(dto.getStartEventDateTime())).
                endEventDateTime(Timestamp.valueOf(dto.getEndEventDateTime())).
                description(dto.getDescription())
                .build();
    }

    public EventResponse mapFrom(EventEntity event) {
        return EventResponse.builder().
                eventId(event.getEventId()).
                name(event.getName()).
                location(event.getLocation()).
                category(event.getCategory()).
                price(event.getPrice()).
                startEventDateTime(String.valueOf(event.getStartEventDateTime())).
                endEventDateTime(String.valueOf(event.getEndEventDateTime())).
                description(event.getDescription())
                .build();
    }
}