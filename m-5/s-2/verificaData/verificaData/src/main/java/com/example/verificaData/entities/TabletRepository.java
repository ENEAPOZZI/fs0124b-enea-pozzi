package com.example.verificaData.entities;

import com.example.verificaData.data.Tablet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TabletRepository extends JpaRepository<Tablet, Long> {


    Optional<Tablet> findByModello(String modello);
}
