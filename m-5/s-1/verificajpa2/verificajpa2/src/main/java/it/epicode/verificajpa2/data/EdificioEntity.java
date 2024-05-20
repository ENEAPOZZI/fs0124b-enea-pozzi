package it.epicode.verificajpa2.data;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data // genera automaticamente i metodi generali
@NoArgsConstructor // fa un costruttore vuoto senza argomenti
@AllArgsConstructor// crea un costruttore che accetta tutti i campi della classe come argomenti
public class EdificioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String indirizzo;
    private String citta;
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL) // Un edificio può avere molte postazioni ( tutte le operazioni eseguite  verranno propagate automaticamente )
    private final List<PostazioneEntity> postazioni = new ArrayList<>();


}
