package com.example.verificaData.services.implementation;

import com.example.verificaData.controllers.records.recordcomplet.DipendentiRecord;
import com.example.verificaData.controllers.records.recordcomplet.LaptopRecord;
import com.example.verificaData.data.Dipendente;
import com.example.verificaData.data.Laptop;
import com.example.verificaData.entities.DipendenteRepository;
import com.example.verificaData.exception.exdipendenti.AggiuntaDipendenteException;
import com.example.verificaData.exception.exdipendenti.DipendenteNotFoundException;
import com.example.verificaData.services.interfaces.DipendenteServiceInt;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class DipendenteServiceImpl  implements DipendenteServiceInt {


    @Autowired
    private DipendenteRepository dipendenteRepository;


    public Dipendente save(DipendentiRecord body) throws IOException {

        dipendenteRepository.findByEmail(body.email()).ifPresent(existingDipendente -> {
            try {
                throw new BadRequestException("il Dipendente con questa email " + body.username() + " è già esistente");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        });

        Dipendente newDipendente= Dipendente.builder()
                .withUsername(body.username())
                .withNome(body.nome())
                .withCognome(body.cognome())
                .withEmail(body.email())
                .build();

        return dipendenteRepository.save(newDipendente);
    }



    @Override
    public Page<Dipendente> getAllDipendenti(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return dipendenteRepository.findAll(pageable);
    }


    @Override
    public Dipendente getDipendenteById(Long id) {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new DipendenteNotFoundException("Dipendente non trovato con ID: " + id));
    }


    @Override
    public void rimuoviDipendente(Long id) {
        try {
            dipendenteRepository.deleteById(id);
        } catch (Exception e) {
            throw new DipendenteNotFoundException("Dipendente non trovato con ID: " + id);


        }
    }


    @Override
    public Dipendente findByIdAndUpdate(Long id, DipendentiRecord body) {
        Dipendente found = dipendenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("dipendente non trovato con ID: " + id));
        found.setNome(body.nome());
        found.setUsername(body.username());
        found.setEmail(body.email());
        found.setCognome(body.cognome());

        return dipendenteRepository.save(found);
    }


}