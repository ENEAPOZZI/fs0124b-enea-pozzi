package com.example.verificaData.services.interfaces;

import com.example.verificaData.controllers.records.recordcomplet.TabletRecord;
import com.example.verificaData.data.Tablet;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface TabletServiceInt  {


    Tablet save(TabletRecord body) throws IOException;

    Page<Tablet> getAllTablet(int page, int size, String sort);

    Tablet getTabletById(Long id);

    void rimuoviTablet(Long id);

    Tablet findByIdAndUpdate(Long id, TabletRecord body);

    Tablet assegnaDispositivo(Long tabletId, Long dipendenteId);




}
