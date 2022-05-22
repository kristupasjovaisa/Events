package eu.codeacademy.events.user.repository;

import eu.codeacademy.events.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByUserId(UUID id);
}
