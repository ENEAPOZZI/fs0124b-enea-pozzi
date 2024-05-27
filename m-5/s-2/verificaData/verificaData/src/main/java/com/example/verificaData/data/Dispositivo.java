package com.example.verificaData.data;

import com.example.verificaData.data.Dipendente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String stato; // Assegnato, Disponibile, Manutenzione, Dismesso
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

}
