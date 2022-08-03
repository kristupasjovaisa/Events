package eu.codeacademy.events.api.event.service;

import eu.codeacademy.events.api.event.dto.AddEventRequest;
import eu.codeacademy.events.api.event.dto.EventResponse;
import eu.codeacademy.events.api.event.dto.UpdateEventRequest;
import eu.codeacademy.events.api.event.mapper.EventMapper;
import eu.codeacademy.events.jpa.event.entity.Event;
import eu.codeacademy.events.jpa.event.repository.EventRepository;
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
        Event event = Event
                .builder()
                .eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        AddEventRequest input = AddEventRequest.builder().build();
        EventResponse eventDto = EventResponse
                .builder()
                .eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        Mockito.when(eventMapper.mapFrom(input)).thenReturn(event);
        Mockito.when(eventMapper.mapFrom(event)).thenReturn(eventDto);

        Mockito.when(eventRepository.save(eventMapper.mapFrom(input))).thenReturn(event);

        EventResponse actual = eventService.add(input);

        Assertions.assertThat(actual.getEventId()).isEqualTo(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
    }

    @Test
    @DisplayName("Shoud update Event by id")
    void update() {

        Event event = Event
                .builder()
                .eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        Event updatedEvent = Event
                .builder()
                .eventId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .build();

        UpdateEventRequest updateEventDto = UpdateEventRequest.builder()
                .eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        EventResponse updatedEventDto = EventResponse
                .builder()
                .eventId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .build();

        Mockito.when(eventRepository.findByEventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(event));
        Mockito.when(eventMapper.mapFrom(updateEventDto, updatedEvent.getId())).thenReturn(event);
        Mockito.when(eventRepository.save(event)).thenReturn(updatedEvent);
        Mockito.when(eventMapper.mapFrom(updatedEvent)).thenReturn(updatedEventDto);
        EventResponse actual = eventService.update(updateEventDto);
        Assertions.assertThat(actual.getEventId()).isEqualTo(UUID.fromString("00000000-0000-0000-0000-000000000000"));
    }

    @Test
    @DisplayName("Shoud delete Event by Id")
    void delete() {

        Event event = Event.builder()
                .id(1l)
                .build();
        Mockito.when(eventRepository.findByEventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(event));
        boolean actual = eventService.delete(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        Mockito.verify(eventRepository, Mockito.times(1)).deleteById(1l);
        Assertions.assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("Shoud find Event by Id")
    void getEventByUUID() {

        Event event = Event
                .builder()
                .eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        EventResponse eventDto = EventResponse
                .builder()
                .eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();
        Mockito.when(eventRepository.findByEventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))).thenReturn(Optional.of(event));
        Mockito.when(eventMapper.mapFrom(event)).thenReturn(eventDto);
        EventResponse actual = eventService.getEventByUUID(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        Assertions.assertThat(actual.getEventId()).isEqualTo(event.getEventId());
    }

    @Test
    void getAllEvents() {

        List<Event> list = new ArrayList<>();
        Event event1 = Event.builder().eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358")).
                build();
        list.add(event1);

        EventResponse eventDto = EventResponse.builder().eventId(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"))
                .build();

        Mockito.when(eventRepository.findAll()).thenReturn(list);
        Mockito.when(eventMapper.mapFrom(event1)).thenReturn(eventDto);

        List<EventResponse> actual = eventService.getAllEvents();
        Assertions.assertThat(actual.get(0).getEventId()).isEqualTo(UUID.fromString("e4dbc123-a7c2-4bee-a519-e1b9ba991358"));
        Assertions.assertThat(actual.size()).isEqualTo(1);
    }
}