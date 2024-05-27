package com.example.verificaData.services.implementation;

import com.example.verificaData.controllers.records.recordcomplet.LaptopRecord;
import com.example.verificaData.controllers.records.recordcomplet.TabletRecord;
import com.example.verificaData.data.Dipendente;
import com.example.verificaData.data.Laptop;
import com.example.verificaData.data.Tablet;
import com.example.verificaData.entities.DipendenteRepository;
import com.example.verificaData.entities.TabletRepository;
import com.example.verificaData.exception.exdipendenti.DipendenteNotFoundException;
import com.example.verificaData.exception.extablet.TabletAlreadyAssignedException;
import com.example.verificaData.exception.extablet.TabletAlreadyExistsException;
import com.example.verificaData.exception.extablet.TabletNotFoundException;
import com.example.verificaData.services.interfaces.TabletServiceInt;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.util.List;

public class TabletServiceImpl implements TabletServiceInt {


    @Autowired
    TabletRepository tabletRepository;

    @Autowired
    DipendenteRepository dipendenteRepository;


    @Override
    public Tablet save(TabletRecord body) throws IOException {

        tabletRepository.findByModello(body.modello()).ifPresent(laptop -> {
            try {
                throw new BadRequestException("il Tablet " + body.modello() + " è già esistente");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        });

        Tablet newTablet = Tablet.builder()
                .withTipo(body.tipo())
                .withStato(body.stato())
                .withModello(body.modello())
                .withSistemaOperativo(body.sistemaOperativo())
                .build();

        return tabletRepository.save(newTablet);
    }


    @Override
    public Page<Tablet> getAllTablet(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return tabletRepository.findAll(pageable);
    }

    @Override
    public Tablet getTabletById(Long id) {
        return tabletRepository.findById(id)
                .orElseThrow(() -> new TabletNotFoundException("Tablet non trovato con ID: " + id));
    }

    @Override
    public void rimuoviTablet(Long id) {
        Tablet tablet = tabletRepository.findById(id)
                .orElseThrow(() -> new TabletNotFoundException("Tablet non trovato con ID: " + id));

        tabletRepository.delete(tablet);

    }


    @Override
    public Tablet findByIdAndUpdate(Long id, TabletRecord body) {
        Tablet found = tabletRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tablet non trovato con ID: " + id));
        found.setTipo(body.tipo());
        found.setStato(body.stato());
        found.setModello(body.modello());
        found.setSistemaOperativo(body.sistemaOperativo());

        return tabletRepository.save(found);
    }

    @Override
    public Tablet assegnaDispositivo(Long tabletId, Long dipendenteId) {
        Tablet tablet = tabletRepository.findById(tabletId)
                .orElseThrow(() -> new TabletNotFoundException("Tablet non trovato con l'ID: " + tabletId));

        // Verifica se il tablet è già stato assegnato
        if (tablet.getDipendente() != null) {
            throw new TabletAlreadyAssignedException("Il tablet con ID " + tabletId + " è già stato assegnato.");
        }

        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new DipendenteNotFoundException("Dipendente non trovato con l'ID: " + dipendenteId));

        tablet.setDipendente(dipendente);
        tablet.setStato("Assegnato");

        return tabletRepository.save(tablet);
    }

}


