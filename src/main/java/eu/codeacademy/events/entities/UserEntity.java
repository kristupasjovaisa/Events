package eu.codeacademy.events.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private UUID userId;
//    private String nickName;
//    private String description;
//    private String location;
//    private LocalDate birthday;

    @OneToMany
    private Set<EventEntity> createdEvents;

    @ManyToMany(mappedBy = "members")
    private Set<EventEntity> events;

}
