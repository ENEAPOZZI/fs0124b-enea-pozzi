package com.example.verificaData.services.interfaces;

import com.example.verificaData.controllers.records.recordcomplet.LaptopRecord;
import com.example.verificaData.data.Laptop;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface LaptopServiceInt {

    Laptop save(LaptopRecord body) throws IOException;

    Page<Laptop> getAllLaptops(int page, int size, String sort);

    Laptop getLaptopById(Long id);

    void rimuoviLaptop(Long id);

    Laptop findByIdAndUpdate(Long id, LaptopRecord body);

    Laptop assegnaDispositivo(Long laptopId, Long dipendenteId);
}
