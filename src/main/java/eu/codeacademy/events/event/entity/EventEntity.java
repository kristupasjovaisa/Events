package eu.codeacademy.events.event.entity;

import eu.codeacademy.events.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
    @Column(length = 50)
    private String category;
    private BigDecimal price;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Timestamp startEventDateTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Timestamp endEventDateTime;
    @Column(length = 350)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity owner;

    @ManyToMany
    private Set<UserEntity> users;
}
