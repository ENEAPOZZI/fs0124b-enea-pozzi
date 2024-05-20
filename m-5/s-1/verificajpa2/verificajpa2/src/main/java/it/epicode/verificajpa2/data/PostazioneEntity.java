package it.epicode.verificajpa2.data;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // genera automaticamente i metodi generali
@NoArgsConstructor // fa un costruttore vuoto senza argomenti
@AllArgsConstructor // crea un costruttore che accetta tutti i campi della classe come argomenti
public class PostazioneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codice;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    private int numeroMassimoOccupanti;
    @ManyToOne(cascade= CascadeType.PERSIST)// Molte postazioni possono appartenere a un singolo edificio
    private  EdificioEntity edificio;

}
