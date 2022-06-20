package eu.codeacademy.events.api.event.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class EventNotFoundException extends RuntimeException{
    private final UUID eventId;
}
