package eu.codeacademy.events.repositories;

import eu.codeacademy.events.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
