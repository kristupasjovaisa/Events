package eu.codeacademy.events.api.event.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class EventDto {

    private UUID eventId;
    private String name;
    private String location;
    private String category;
    private BigDecimal price;
    private String startEventDateTime;
    private String endEventDateTime;
    private String description;
}
