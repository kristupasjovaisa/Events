package eu.codeacademy.events.event.mapper;

import eu.codeacademy.events.event.dto.AddEventDto;
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
}