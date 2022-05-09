package eu.codeacademy.events.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "events")
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
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "events_users",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<UserEntity> members = new ArrayList<>();

    public EventEntity(long id) {
        this.id = id;
    }

    public void addMembers(UserEntity member) {
        members.add(member);
//        member.getEvents().add(this);
    }

    public void addOwner(UserEntity owner) {
        this.owner = owner;
//        owner.getCreatedEvents().add(this);
    }
}
