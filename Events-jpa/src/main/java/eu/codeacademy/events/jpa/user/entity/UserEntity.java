package eu.codeacademy.events.jpa.user.entity;

import eu.codeacademy.events.jpa.authority.entity.Authority;
import eu.codeacademy.events.jpa.event.entity.EventEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String city;
    @Column(length =50)
    private String email;
    @Column(length = 100)
    private String password;
    @Column(length = 20)
    private String phoneNumber;

    @ManyToMany(mappedBy = "users")
    private Set<EventEntity> events;

    @OneToMany(mappedBy = "owner")
    private Set<EventEntity> createdEvents;

    @ManyToMany
    private Set<Authority> authorities;
}
