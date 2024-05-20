package it.epicode.verificajpa2.data;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data // genera automaticamente i metodi generali
@NoArgsConstructor // fa un costruttore vuoto senza argomenti
@AllArgsConstructor// crea un costruttore che accetta tutti i campi della classe come argomenti
public class UtenteEntity {


    @Id
    private String username;
    private String nomeCompleto;
    private String email;
    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL) // Un utente può avere molte prenotazioni
    private List<PrenotazioneEntity> prenotazioni = new ArrayList<>();
}
