package eu.codeacademy.events.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID eventId;
    @Column(length = 20)
    private String name;
    @Column(length = 50)
    private String location;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startEventDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endEventDate;
    @Column(length = 350)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity owner;

    @ManyToMany
    private Set<UserEntity> users;
}
