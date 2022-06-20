package eu.codeacademy.events.jpa.user.repository;

import eu.codeacademy.events.jpa.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.nickname = ?1")
    Optional<UserEntity> findUserByNickname(String nickname);
    Optional<UserEntity> findByUserId(UUID id);


}
