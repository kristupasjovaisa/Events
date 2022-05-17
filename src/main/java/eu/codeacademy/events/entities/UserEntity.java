package eu.codeacademy.events.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private UUID userId;
    @Column(length = 20)
    private String name;
//    private String description;
//    private String location;
//    private LocalDate birthday;

//    @OneToMany
//    private Set<EventEntity> createdEvents;

    @ManyToMany
    private Set<EventEntity> events;

}
