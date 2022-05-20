package eu.codeacademy.events.event.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventDto {

    private String name;
    private String location;
    private String category;
    private String price;
    private String startEventDateTime;
    private String endEventDateTime;
    private String description;
}
