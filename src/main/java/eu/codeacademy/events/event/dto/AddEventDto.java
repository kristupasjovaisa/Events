package eu.codeacademy.events.event.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@ToString
public class AddEventDto {

    private String name;
    private String location;
    private String category;
    private BigDecimal price;
    private String startEventDateTime;
    private String endEventDateTime;
    private String description;
    private UUID ownerId;
}
