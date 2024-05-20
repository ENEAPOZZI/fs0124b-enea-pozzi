package it.epicode.verificajpa2.repository;

import it.epicode.verificajpa2.data.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<UtenteEntity, String> {
}
