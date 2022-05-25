package eu.codeacademy.events.event.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AddEventDto {

    private String name;
    private String location;
    private String category;
    private BigDecimal price;
    private String startEventDateTime;
    private String endEventDateTime;
    private String description;
}
