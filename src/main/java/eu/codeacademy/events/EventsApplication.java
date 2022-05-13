package eu.codeacademy.events;

import eu.codeacademy.events.repositories.EventRepository;
import eu.codeacademy.events.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventsApplication.class, args);
    }

    @Bean
    public void commandLineRunner(EventRepository eventRepository, UserRepository userRepository) {
//        return
//            UserEntity user1 = new UserEntity();
////            UserEntity user2 = new UserEntity();
//            userRepository.save(user1);
//            EventEntity event = new EventEntity();
//            event.addMembers(user1);
////            event.addMembers(user2);
//
////            event.addOwner(user1);
//            eventRepository.save(event);

    }
}
