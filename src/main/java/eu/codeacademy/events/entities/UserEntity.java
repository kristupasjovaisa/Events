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
    private UUID userId;
    @Column(length = 20)
    private String nickname;
    @Column(length = 50)
    private String location;
    @Column(length =50)
    private String email;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthday;
    @Column(length = 350)
    private String description;

    @ManyToMany(mappedBy = "users")
    private Set<EventEntity> events;

    @OneToMany(mappedBy = "owner")
    private Set<EventEntity> createdEvents;

}
