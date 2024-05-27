package com.example.verificaData.entities;

import com.example.verificaData.data.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LaptopRepository  extends JpaRepository<Laptop, Long> {
    Optional<Object> findByModello(String modello);

}
