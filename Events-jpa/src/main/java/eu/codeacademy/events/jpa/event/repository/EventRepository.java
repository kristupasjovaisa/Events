package eu.codeacademy.events.jpa.event.repository;

import eu.codeacademy.events.jpa.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event,Long> {
    Optional<Event> findByEventId(UUID id);
}
