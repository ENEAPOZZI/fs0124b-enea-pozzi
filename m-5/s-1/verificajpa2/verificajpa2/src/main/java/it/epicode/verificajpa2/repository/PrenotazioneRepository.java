package it.epicode.verificajpa2.repository;

import it.epicode.verificajpa2.data.PrenotazioneEntity;
import it.epicode.verificajpa2.data.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrenotazioneRepository  extends JpaRepository<PrenotazioneEntity, Long> {


    //  per trovare tutte le prenotazioni associate a un determinato utente
    List<PrenotazioneEntity> findByUtente(UtenteEntity utente);

}
