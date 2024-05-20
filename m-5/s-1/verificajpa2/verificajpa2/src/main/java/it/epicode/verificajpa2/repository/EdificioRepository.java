package it.epicode.verificajpa2.repository;

import it.epicode.verificajpa2.data.EdificioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<EdificioEntity, Long> {
}
