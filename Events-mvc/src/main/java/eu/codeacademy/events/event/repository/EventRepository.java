package eu.codeacademy.events.event.repository;

import eu.codeacademy.events.event.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<EventEntity,Long> {
    Optional<EventEntity> findByEventId(UUID id);
}
