package it.epicode.verificajpa2.repository;


import it.epicode.verificajpa2.data.PostazioneEntity;
import it.epicode.verificajpa2.data.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<PostazioneEntity, Long> {


    //  per trovare tutte le postazioni di un determinato tipo in un edificio specifico
    List<PostazioneEntity> findByTipoAndEdificioCitta(TipoPostazione tipo, String citta);
}
