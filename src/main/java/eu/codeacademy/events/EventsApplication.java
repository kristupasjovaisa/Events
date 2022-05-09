package eu.codeacademy.events;

import eu.codeacademy.events.entities.EventEntity;
import eu.codeacademy.events.entities.UserEntity;
import eu.codeacademy.events.repositories.EventRepository;
import eu.codeacademy.events.repositories.UserRepository;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(EventRepository eventRepository, UserRepository userRepository) {
        return (args) -> {
            UserEntity user1 = new UserEntity(1l);
            UserEntity user2 = new UserEntity(2l);
            EventEntity event = new EventEntity(3l);
            event.addMembers(user1);
            event.addMembers(user2);
            userRepository.save(user1);
            event.addOwner(user1);
            eventRepository.save(event);
        };
    }
}
