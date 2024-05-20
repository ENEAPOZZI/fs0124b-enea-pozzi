package it.epicode.verificajpa2.services;


import it.epicode.verificajpa2.data.PostazioneEntity;
import it.epicode.verificajpa2.data.PrenotazioneEntity;
import it.epicode.verificajpa2.data.TipoPostazione;
import it.epicode.verificajpa2.data.UtenteEntity;
import it.epicode.verificajpa2.repository.PostazioneRepository;
import it.epicode.verificajpa2.repository.PrenotazioneRepository;
import it.epicode.verificajpa2.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {



    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    @Autowired
    UtenteRepository utenteRepository;

    @Autowired
    PostazioneRepository postazioneRepository;


    public void effettuaPrenotazione(UtenteEntity utente, PostazioneEntity postazione, LocalDate data) {
        // Crea una nuova prenotazione
        PrenotazioneEntity prenotazione = new PrenotazioneEntity();
        prenotazione.setData(data);
        prenotazione.setPostazione(postazione);

        // Aggiunge la prenotazione alla lista di prenotazioni dell'utente
        utente.getPrenotazioni().add(prenotazione);

        // Salva la prenotazione nel database
        prenotazioneRepository.save(prenotazione);
        // Aggiorna l'utente nel database per riflettere la nuova prenotazione
        utenteRepository.save(utente);
    }


    public List<PostazioneEntity> ricercaPostazioniPerTipoECitta(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificioCitta(tipo, citta);
    }



}
