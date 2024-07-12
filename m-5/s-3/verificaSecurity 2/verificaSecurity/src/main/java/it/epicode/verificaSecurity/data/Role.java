package it.epicode.verificaSecurity.data;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "roles")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor

public class Role extends EntitaBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seguenza")
    @SequenceGenerator(name = "roles_seguenza", sequenceName = "roles_seguenza")
    private long id;
    @Column(length = 15, unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private final List<User> users = new ArrayList<>();
}
