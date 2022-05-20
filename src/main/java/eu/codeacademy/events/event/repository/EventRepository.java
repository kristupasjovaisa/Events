package eu.codeacademy.events.event.repository;

import eu.codeacademy.events.event.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity,Long> {
}
