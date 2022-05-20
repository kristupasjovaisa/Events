package eu.codeacademy.events.user.repository;

import eu.codeacademy.events.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
