package com.example.verificaData.controllers;


import com.example.verificaData.controllers.records.recordcomplet.SmartphoneRecord;
import com.example.verificaData.data.Smartphone;
import com.example.verificaData.services.interfaces.SmartphoneServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/smartphone")
public class SmartphoneController {

    @Autowired
    private SmartphoneServiceInt smartphoneService;

    @PostMapping("/aggiungi")
    public ResponseEntity<?> aggiungiSmartphone(@Validated @RequestBody SmartphoneRecord body, BindingResult validation) {
        if (validation.hasErrors()) {
            // Se ci sono errori di validazione, restituisci una risposta BAD_REQUEST con i dettagli degli errori
            return ResponseEntity.badRequest().body("Errore di validazione: " + validation.getAllErrors());
        }

        try {
            Smartphone nuovoSmartphone = smartphoneService.save(body);
            return ResponseEntity.ok(nuovoSmartphone);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{smartphoneid}")
    public ResponseEntity<Smartphone> getSmartphoneById(@PathVariable Long id) {
        try {
            Smartphone smartphone = smartphoneService.getSmartphoneById(id);
            return ResponseEntity.ok(smartphone);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{smartphoneid}")
    public ResponseEntity<Void> rimuoviSmartphone(@PathVariable Long id) {
        try {
            smartphoneService.rimuoviSmartphone(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{smartphoneid}")
    public ResponseEntity<Smartphone> aggiornaSmartphone(@PathVariable Long id, @RequestBody SmartphoneRecord body) {
        try {
            Smartphone updatedSmartphone = smartphoneService.findByIdAndUpdate(id, body);
            return ResponseEntity.ok(updatedSmartphone);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{smartphoneId}/assegna/{dipendenteId}")
    public ResponseEntity<Smartphone> assegnaSmartphone(@PathVariable Long smartphoneId, @PathVariable Long dipendenteId) {
        try {
            Smartphone smartphone = smartphoneService.assegnaDispositivo(smartphoneId, dipendenteId);
            return ResponseEntity.ok(smartphone);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<Smartphone>> getAllSmartphones(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size,
                                                              @RequestParam(defaultValue = "id") String sort) {
        try {
            Page<Smartphone> smartphones = smartphoneService.getAllSmartphones(page, size, sort);
            return ResponseEntity.ok(smartphones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
