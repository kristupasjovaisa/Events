package eu.codeacademy.events.jpa.user.repository;

import eu.codeacademy.events.jpa.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u JOIN FETCH u.authorities WHERE u.email = :email")
    Optional<User> findUserByEmail(String email);
    Optional<User> findByUserId(UUID id);


}