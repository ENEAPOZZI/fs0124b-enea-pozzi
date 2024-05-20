package it.epicode.verificajpa2;



import it.epicode.verificajpa2.data.*;
import it.epicode.verificajpa2.repository.EdificioRepository;
import it.epicode.verificajpa2.repository.PostazioneRepository;
import it.epicode.verificajpa2.repository.PrenotazioneRepository;
import it.epicode.verificajpa2.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
/*IO AVEVO CONSEGNATO SUBITO VENERDI MA NON HO FINITO IL COMPITOL'HO FINITO DOMENICA (DATO CH C'ERA UN UN PUNTO IN PIù PER CHI CONSEGNAVA PRIMA ERA PER SPECIFICARE)*/

@Component
public class SaveRunner implements CommandLineRunner {


    @Autowired
    EdificioRepository edificioRepository;

    @Autowired
    PostazioneRepository postazioneRepository;

    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    @Autowired
    UtenteRepository utenteRepository;

    @Override
    public void run(String... args) throws Exception {
        // Creazione degli edifici
        EdificioEntity edificio1 = new EdificioEntity(1L, "NomeEdificio1", "Indirizzo1", "Citta1");
        EdificioEntity edificio2 = new EdificioEntity(2L, "NomeEdificio2", "Indirizzo2", "Citta2");

        // Salvataggio degli edifici nel database

        edificioRepository.save(edificio1);
        edificioRepository.save(edificio2);

        // Creazione delle postazioni
        PostazioneEntity postazione1 = new PostazioneEntity(1L, "Codice1", "Descrizione1", TipoPostazione.PRIVATO, 5, edificio1);
        PostazioneEntity postazione2 = new PostazioneEntity(2L, "Codice2", "Descrizione2", TipoPostazione.OPENSPACE, 10, edificio2);

        // Salvataggio delle postazioni nel database
        postazioneRepository.save(postazione1);
        postazioneRepository.save(postazione2);

        // Creazione degli utenti
        UtenteEntity utente1 = new UtenteEntity("username1", "Nome Cognome 1", "email1@example.com", null);
        UtenteEntity utente2 = new UtenteEntity("username2", "Nome Cognome 2", "email2@example.com", null);

        // Salvataggio degli utenti nel database
        utenteRepository.save(utente1);
        utenteRepository.save(utente2);

        // Creazione delle prenotazioni
        LocalDate domani = LocalDate.now().plusDays(1);

        PrenotazioneEntity prenotazione1 = new PrenotazioneEntity(1L, domani, postazione1, utente1);
        PrenotazioneEntity prenotazione2 = new PrenotazioneEntity(2L, domani, postazione2, utente2);

        // Salvataggio delle prenotazioni nel database
        prenotazioneRepository.save(prenotazione1);
        prenotazioneRepository.save(prenotazione2);

        // utlizzo delle query

        List<PostazioneEntity> postazioni = postazioneRepository.findByTipoAndEdificioCitta(TipoPostazione.PRIVATO, "Citta1");
        System.out.println("Postazioni di tipo PRIVATO nell'edificio di Citta1:");
        postazioni.forEach(System.out::println);



        List<PrenotazioneEntity> prenotazioniUtente = prenotazioneRepository.findByUtente(utente1);
        System.out.println("Prenotazioni dell'utente 1:");
        prenotazioniUtente.forEach(System.out::println);
    }

}
