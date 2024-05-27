package com.example.verificaData.entities;

import com.example.verificaData.data.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {

    Optional<Dipendente> findByEmail(String email);

    Optional<Dipendente> findById(Long id);

}
