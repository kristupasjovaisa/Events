package eu.codeacademy.events.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    private UUID eventId;
//    private String name;
//    private String description;
//    private String location;
//    private LocalDateTime dateTime;
//
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity owner;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<UserEntity> members;

}
