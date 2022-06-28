package eu.codeacademy.events.jpa.file.repository;

import eu.codeacademy.events.jpa.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {
}
