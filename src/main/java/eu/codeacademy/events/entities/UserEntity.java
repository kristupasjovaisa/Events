package eu.codeacademy.events.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID userId;
    private String nickName;
    private String description;
    private String location;
    private LocalDate birthday;

    @OneToMany
    private List<EventEntity> createEvents = new ArrayList<>();

    @OneToMany
    private List<EventEntity> events = new ArrayList<>();
}
