package com.example.verificaData.controllers;


import com.example.verificaData.controllers.records.recordcomplet.LaptopRecord;
import com.example.verificaData.data.Laptop;
import com.example.verificaData.services.implementation.LaptopServiceImpl;
import com.example.verificaData.services.interfaces.LaptopServiceInt;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laptop")
public class LaptopController {


    @Autowired
    private LaptopServiceInt laptopService;

    @PostMapping("/aggiungi")
    public ResponseEntity<?> aggiungiLaptop(@Validated @RequestBody LaptopRecord body, BindingResult validation) {
        if (validation.hasErrors()) {
            return ResponseEntity.badRequest().body("Errore di validazione: " + validation.getAllErrors());
        }

        try {
            Laptop nuovoLaptop = laptopService.save(body);
            return ResponseEntity.ok(nuovoLaptop);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable Long id) {
        try {
            Laptop laptop = laptopService.getLaptopById(id);
            return ResponseEntity.ok(laptop);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> rimuoviLaptop(@PathVariable Long id) {
        try {
            laptopService.rimuoviLaptop(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laptop> aggiornaLaptop(@PathVariable Long id, @RequestBody LaptopRecord body) {
        try {
            Laptop updatedLaptop = laptopService.findByIdAndUpdate(id, body);
            return ResponseEntity.ok(updatedLaptop);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{laptopId}/assegna/{dipendenteId}")
    public ResponseEntity<Laptop> assegnaDispositivo(@PathVariable Long laptopId, @PathVariable Long dipendenteId) {
        try {
            Laptop laptop = laptopService.assegnaDispositivo(laptopId, dipendenteId);
            return ResponseEntity.ok(laptop);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("")
    public ResponseEntity<Page<Laptop>> getAllLaptops(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size,
                                                      @RequestParam(defaultValue = "id") String sort) {
        try {
            Page<Laptop> laptops = laptopService.getAllLaptops(page, size, sort);
            return ResponseEntity.ok(laptops);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }




}
