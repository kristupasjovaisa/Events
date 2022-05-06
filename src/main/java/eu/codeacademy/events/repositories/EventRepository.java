package eu.codeacademy.events.repositories;

import eu.codeacademy.events.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity,Long> {
}
