package com.example.verificaData.data;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@Table(name = "dipendenti" , indexes = { @Index(name = "idx_email_unique", columnList = "email", unique = true) })
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    @OneToMany(mappedBy = "dipendente")
    private List<Dispositivo> dispositiviAssegnati;
}