package com.example.verificaData.services.implementation;

import com.example.verificaData.controllers.records.recordcomplet.LaptopRecord;
import com.example.verificaData.controllers.records.recordcomplet.SmartphoneRecord;
import com.example.verificaData.data.Dipendente;
import com.example.verificaData.data.Laptop;
import com.example.verificaData.data.Smartphone;
import com.example.verificaData.entities.DipendenteRepository;
import com.example.verificaData.entities.SmartphoneRepository;
import com.example.verificaData.exception.exdipendenti.DipendenteNotFoundException;
import com.example.verificaData.exception.exsmartphone.SmartphoneAlreadyAssignedException;
import com.example.verificaData.exception.exsmartphone.SmartphoneAlreadyExistsException;
import com.example.verificaData.exception.exsmartphone.SmartphoneNotFoundException;
import com.example.verificaData.services.interfaces.SmartphoneServiceInt;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class SmartphoneServiceImpl implements SmartphoneServiceInt {

    @Autowired
    SmartphoneRepository smartphoneRepository;



    @Autowired
    DipendenteRepository dipendenteRepository;

    @Override
    public Smartphone save(SmartphoneRecord body) throws IOException {
        smartphoneRepository.findByModello(body.modello()).ifPresent(smartphone -> {
            try {
                throw new BadRequestException("Lo smartphone " + body.modello() + " è già esistente");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        });

        Smartphone newSmartphone = Smartphone.builder()
                .withTipo(body.tipo())
                .withStato(body.stato())
                .withModello(body.modello())
                .withSistemaOperativo(body.sistemaOperativo())
                .build();

        return smartphoneRepository.save(newSmartphone);
    }

    @Override
    public Page<Smartphone> getAllSmartphones(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return smartphoneRepository.findAll(pageable);
    }
    @Override
    public Smartphone getSmartphoneById(Long id) {
        return smartphoneRepository.findById(id)
                .orElseThrow(() -> new SmartphoneNotFoundException("Smartphone non trovato con l'ID: " + id));
    }

    @Override
    public void rimuoviSmartphone(Long id) {
        Smartphone smartphone = smartphoneRepository.findById(id)
                .orElseThrow(() -> new SmartphoneNotFoundException("Smartphone non trovato con l'ID: " + id));

        smartphoneRepository.delete(smartphone);
    }




    public Smartphone findByIdAndUpdate(Long id, SmartphoneRecord body) {
        Smartphone found = smartphoneRepository.findById(id)
                .orElseThrow(() -> new SmartphoneNotFoundException("Smartphone non trovato con ID: " + id));
        found.setTipo(body.tipo());
        found.setStato(body.stato());
        found.setModello(body.modello());
        found.setSistemaOperativo(body.sistemaOperativo());

        return smartphoneRepository.save(found);
    }



        @Override
    public Smartphone assegnaDispositivo(Long smartphoneId, Long dipendenteId) {
        // Trova lo smartphone
        Smartphone smartphone = smartphoneRepository.findById(smartphoneId)
                .orElseThrow(() -> new SmartphoneNotFoundException("Smartphone non trovato con l'ID: " + smartphoneId));

        // Verifica se lo smartphone è già stato assegnato
        if (smartphone.getDipendente() != null) {
            throw new SmartphoneAlreadyAssignedException("Lo smartphone con ID " + smartphoneId + " è già stato assegnato.");
        }

        // Trova il dipendente
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new DipendenteNotFoundException("Dipendente non trovato con l'ID: " + dipendenteId));

        // Assegna lo smartphone al dipendente
        smartphone.setDipendente(dipendente);
        smartphone.setStato("Assegnato");

        // Salva lo smartphone aggiornato nel repository
        return smartphoneRepository.save(smartphone);
    }

}










