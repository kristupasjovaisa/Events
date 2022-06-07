package eu.codeacademy.events.event.service;

import eu.codeacademy.events.event.dto.AddEventDto;
import eu.codeacademy.events.event.dto.EventDto;
import eu.codeacademy.events.event.dto.UpdateEventDto;
import eu.codeacademy.events.event.entity.EventEntity;
import eu.codeacademy.events.event.mapper.EventMapper;
import eu.codeacademy.events.event.repository.EventRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    private EventMapper eventMapper;

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @Test
    @DisplayName("Shoud add Events")
    void add() {
        EventEntity event = EventEntity
                .builder()
                .eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        AddEventDto input = AddEventDto.builder().build();
        EventDto eventDto = EventDto
                .builder()
                .eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        Mockito.when(eventMapper.mapFrom(input)).thenReturn(event);
        Mockito.when(eventMapper.mapFrom(event)).thenReturn(eventDto);

        Mockito.when(eventRepository.save(eventMapper.mapFrom(input))).thenReturn(event);

        EventDto actual = eventService.add(input);

        Assertions.assertThat(actual.getEventId()).isEqualTo(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
    }

    @Test
    @DisplayName("Shoud update Event by id")
    void update() {

        EventEntity event = EventEntity
                .builder()
                .eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        EventEntity updatedEvent = EventEntity
                .builder()
                .eventId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .build();

        UpdateEventDto updateEventDto = UpdateEventDto.builder()
                .eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        EventDto updatedEventDto = EventDto
                .builder()
                .eventId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .build();

        Mockito.when(eventRepository.findByEventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(event));
        Mockito.when(eventMapper.mapFrom(updateEventDto, updatedEvent.getId())).thenReturn(event);
        Mockito.when(eventRepository.save(event)).thenReturn(updatedEvent);
        Mockito.when(eventMapper.mapFrom(updatedEvent)).thenReturn(updatedEventDto);
        EventDto actual = eventService.update(updateEventDto);
        Assertions.assertThat(actual.getEventId()).isEqualTo(UUID.fromString("00000000-0000-0000-0000-000000000000"));
    }

    @Test
    @DisplayName("Shoud delete Event by Id")
    void delete() {

        EventEntity event = EventEntity.builder()
                .id(1l)
                .build();
        Mockito.when(eventRepository.findByEventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(event));
        boolean actual = eventService.delete(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        verify(eventRepository, Mockito.times(1)).deleteById(1l);
        Assertions.assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("Shoud find Event by Id")
    void getEventByUUID() {

        EventEntity event = EventEntity
                .builder()
                .eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        EventDto eventDto = EventDto
                .builder()
                .eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();
        Mockito.when(eventRepository.findByEventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(event));
        Mockito.when(eventMapper.mapFrom(event)).thenReturn(eventDto);
        EventDto actual = eventService.getEventByUUID(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        Assertions.assertThat(actual.getEventId()).isEqualTo(event.getEventId());
    }

    @Test
    void getAllEvents() {

        List<EventEntity> list = new ArrayList<>();
        EventEntity event1 = EventEntity.builder().eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358")).
                build();
        list.add(event1);

        EventDto eventDto = EventDto.builder().eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        Mockito.when(eventRepository.findAll()).thenReturn(list);
        Mockito.when(eventMapper.mapFrom(event1)).thenReturn(eventDto);

        List<EventDto> actual = eventService.getAllEvents();
        Assertions.assertThat(actual.get(0).getEventId()).isEqualTo(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        Assertions.assertThat(actual.size()).isEqualTo(1);
    }
}