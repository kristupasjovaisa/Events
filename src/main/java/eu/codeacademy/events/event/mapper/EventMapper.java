package eu.codeacademy.events.event.mapper;

import eu.codeacademy.events.event.dto.AddEventDto;
import eu.codeacademy.events.event.dto.EventDto;
import eu.codeacademy.events.event.dto.UpdateEventDto;
import eu.codeacademy.events.event.entity.EventEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Component
public class EventMapper {

    public EventEntity mapTo(AddEventDto dto) {
        return EventEntity.builder().
                name(dto.getName()).
                location(dto.getLocation()).
                category(dto.getCategory()).
                price(new BigDecimal(dto.getPrice())).
                startEventDateTime(Timestamp.valueOf(dto.getStartEventDateTime())).
                endEventDateTime(Timestamp.valueOf(dto.getEndEventDateTime())).
                description(dto.getDescription())
                .build();
    }

    public EventEntity mapTo(UpdateEventDto dto) {
        return EventEntity.builder().
                name(dto.getName()).
                location(dto.getLocation()).
                category(dto.getCategory()).
                price(new BigDecimal(dto.getPrice())).
                startEventDateTime(Timestamp.valueOf(dto.getStartEventDateTime())).
                endEventDateTime(Timestamp.valueOf(dto.getEndEventDateTime())).
                description(dto.getDescription())
                .build();
    }

    public EventDto mapTo(EventEntity event) {
        return EventDto.builder().
                name(event.getName()).
                location(event.getLocation()).
                category(event.getCategory()).
                price(String.valueOf(event.getPrice())).
                startEventDateTime(String.valueOf(event.getStartEventDateTime())).
                endEventDateTime(String.valueOf(event.getEndEventDateTime())).
                description(event.getDescription())
                .build();
    }
}