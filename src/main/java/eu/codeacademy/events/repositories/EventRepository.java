package eu.codeacademy.events.repositories;

import eu.codeacademy.events.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity,Long> {
}
