package com.example.verificaData.services.interfaces;

import com.example.verificaData.controllers.records.recordcomplet.DipendentiRecord;
import com.example.verificaData.data.Dipendente;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface DipendenteServiceInt {
    Dipendente save(DipendentiRecord body) throws IOException;

    Page<Dipendente> getAllDipendenti(int page, int size, String sort);

    Dipendente getDipendenteById(Long id);

    void rimuoviDipendente(Long id);

    Dipendente findByIdAndUpdate(Long id, DipendentiRecord body);

}
