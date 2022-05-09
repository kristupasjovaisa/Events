package eu.codeacademy.events.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
//    private String nickName;
//    private String description;
//    private String location;
//    private LocalDate birthday;

    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL
    )
    private List<EventEntity> createdEvents = new ArrayList<>();

    @ManyToMany(mappedBy = "members", cascade = CascadeType.ALL)
    private List<EventEntity> events = new ArrayList<>();

    public UserEntity(long id) {
        this.id = id;
    }
}
