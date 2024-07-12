package it.epicode.verificaSecurity.repository;

import jdk.jfr.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<it.epicode.verificaSecurity.data.Event> findByEventName(String eventName);


     it.epicode.verificaSecurity.data.Event save(it.epicode.verificaSecurity.data.Event event);
    // sinceramente non capisco bene perche me lo coreggie cosi dice
    // che altrimenti non li passo un oggetto del tipo giusto.
    // mi ha dato molti problemi questo semplice save l'unico modo per farlo funzioanre e questo
}
