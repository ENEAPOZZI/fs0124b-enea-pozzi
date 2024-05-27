package com.example.verificaData.services.interfaces;

import com.example.verificaData.controllers.records.recordcomplet.SmartphoneRecord;
import com.example.verificaData.data.Smartphone;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface SmartphoneServiceInt {

    Smartphone save(SmartphoneRecord body) throws IOException;

    Page<Smartphone> getAllSmartphones(int page, int size, String sort);

    Smartphone getSmartphoneById(Long id);

    void rimuoviSmartphone(Long id);

    Smartphone findByIdAndUpdate(Long id, SmartphoneRecord body);

    Smartphone assegnaDispositivo(Long smartphoneId, Long dipendenteId);


}
