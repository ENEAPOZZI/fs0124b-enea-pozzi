package it.epicode.verificajpa2.data;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data // genera automaticamente i metodi generali
@NoArgsConstructor // fa un costruttore vuoto senza argomenti
@AllArgsConstructor// crea un costruttore che accetta tutti i campi della classe come argomenti
public class PrenotazioneEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @ManyToOne // Molte prenotazioni possono essere associate a una singola postazione
    private PostazioneEntity postazione;
    @ManyToOne // Molte prenotazioni possono essere effettuate da un singolo utente
    private UtenteEntity utente;

}
