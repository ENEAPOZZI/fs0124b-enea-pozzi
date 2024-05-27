package com.example.verificaData.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "smartphone")
public class Smartphone  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String stato; // Assegnato, Disponibile, Manutenzione, Dismesso
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;
    private String modello;
    private String sistemaOperativo;

}
