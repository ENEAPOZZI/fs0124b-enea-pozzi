package com.example.verificaData.services.implementation;

import com.example.verificaData.controllers.records.recordcomplet.LaptopRecord;
import com.example.verificaData.data.Dipendente;
import com.example.verificaData.data.Laptop;
import com.example.verificaData.entities.DipendenteRepository;
import com.example.verificaData.entities.LaptopRepository;
import com.example.verificaData.exception.exdipendenti.DipendenteNotFoundException;
import com.example.verificaData.exception.exlaptop.LaptopAlreadyAssignedException;
import com.example.verificaData.exception.exlaptop.LaptopAlreadyExistsException;
import com.example.verificaData.exception.exlaptop.LaptopNotFoundException;
import com.example.verificaData.services.interfaces.LaptopServiceInt;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.util.List;

public class LaptopServiceImpl implements LaptopServiceInt {


    @Autowired
    LaptopRepository laptopRepository;

    @Autowired
    DipendenteRepository dipendenteRepository;


    public Laptop save(LaptopRecord body) throws IOException {

        laptopRepository.findByModello(body.modello()).ifPresent(laptop -> {
            try {
                throw new BadRequestException("il laptop " + body.modello() + " è già esistente");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        });

        Laptop newLaptop = Laptop.builder()
                .withTipo(body.tipo())
                .withStato(body.stato())
                .withModello(body.modello())
                .withSistemaOperativo(body.sistemaOperativo())
                .build();

        return laptopRepository.save(newLaptop);
    }

    @Override
    public Page<Laptop> getAllLaptops(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return laptopRepository.findAll(pageable);
    }

    @Override
    public Laptop getLaptopById(Long id) {
        return laptopRepository.findById(id)
                .orElseThrow(() -> new LaptopNotFoundException("Laptop non trovato con ID: " + id));
    }

    @Override
    public void rimuoviLaptop(Long id) {
        Laptop laptop = laptopRepository.findById(id)
                .orElseThrow(() -> new LaptopNotFoundException("Laptop non trovato con ID: " + id));
        laptopRepository.delete(laptop);
    }


   @Override
    public Laptop findByIdAndUpdate(Long id, LaptopRecord body) {
        Laptop found = laptopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laptop non trovato con ID: " + id));
        found.setTipo(body.tipo());
        found.setStato(body.stato());
        found.setModello(body.modello());
        found.setSistemaOperativo(body.sistemaOperativo());

        return laptopRepository.save(found);
    }

    @Override
    public Laptop assegnaDispositivo(Long laptopId, Long dipendenteId) {

        Laptop laptop = laptopRepository.findById(laptopId)
                .orElseThrow(() -> new LaptopNotFoundException("Laptop non trovato con l'ID: " + laptopId));

        if (laptop.getDipendente() != null) {
            throw new LaptopAlreadyAssignedException("Il laptop con ID " + laptopId + " è già stato assegnato.");
        }

        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new DipendenteNotFoundException("Dipendente non trovato con l'ID: " + dipendenteId));

        laptop.setDipendente(dipendente);
        laptop.setStato("Occupato");

        return laptopRepository.save(laptop);

    }

}
