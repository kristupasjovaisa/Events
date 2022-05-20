package eu.codeacademy.events.event.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Builder
@Data
public class Event {
    private UUID eventId;
    private String name;
    private String location;
    private String category;
    private BigDecimal price;
    private Timestamp startEventDateTime;
    private Timestamp endEventDateTime;
    private String description;
}
