package eu.codeacademy.events.jpa.authority.repository;

import eu.codeacademy.events.jpa.authority.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
