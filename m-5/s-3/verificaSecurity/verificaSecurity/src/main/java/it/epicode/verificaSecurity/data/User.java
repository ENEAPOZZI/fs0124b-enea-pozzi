package it.epicode.verificaSecurity.data;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class User extends EntitaBase {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seguenza")
    @SequenceGenerator(name = "users_seguenza", sequenceName = "users_seguenza")
    private long id;
    @Column(length = 125, unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String username;
    @Column(length = 125, nullable = false)
    private String password;
    @Column(length = 25)
    private String friendlyName;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private final List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private final List<Event> events = new ArrayList<>();


}
