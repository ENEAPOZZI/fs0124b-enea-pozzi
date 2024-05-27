package com.example.verificaData.entities;

import com.example.verificaData.data.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long > {

    Optional<Smartphone> findById(Long id);
    Optional<Smartphone> findByModello(String modello);



}
