package eu.codeacademy.events.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID eventId;
    private String name;
    private String description;
    private String location;
    private LocalDateTime dateTime;

    @ManyToOne(cascade = {CascadeType.ALL})
    private UserEntity owner;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JoinTable(name = "events_users",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<UserEntity> members = new ArrayList<>();
}
