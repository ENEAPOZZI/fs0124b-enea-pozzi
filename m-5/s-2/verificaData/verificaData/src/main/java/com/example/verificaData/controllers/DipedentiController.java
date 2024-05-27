package com.example.verificaData.controllers;


import com.example.verificaData.controllers.records.recordcomplet.DipendentiRecord;
import com.example.verificaData.data.Dipendente;
import com.example.verificaData.services.interfaces.DipendenteServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dipendenti")
public class DipedentiController {


    @Autowired
     DipendenteServiceInt dipendenteService;

    @PostMapping("/aggiungi")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Dipendente> aggiungiDipendente(@RequestBody DipendentiRecord body) {
        try {
            Dipendente nuovoDipendente = dipendenteService.save(body);
            return ResponseEntity.ok(nuovoDipendente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{dipendentiid}")
    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable Long id) {
        try {
            Dipendente dipendente = dipendenteService.getDipendenteById(id);
            return ResponseEntity.ok(dipendente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{dipendentiid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> rimuoviDipendente(@PathVariable Long id) {
        try {
            dipendenteService.rimuoviDipendente(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{dipendentiid}")
    public ResponseEntity<Dipendente> aggiornaDipendente(@PathVariable Long id, @RequestBody DipendentiRecord body) {
        try {
            Dipendente updatedDipendente = dipendenteService.findByIdAndUpdate(id, body);
            return ResponseEntity.ok(updatedDipendente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<Page<Dipendente>> getAllDipendenti(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size,
                                                             @RequestParam(defaultValue = "id") String sort) {
        try {
            Page<Dipendente> dipendenti = dipendenteService.getAllDipendenti(page, size, sort);
            return ResponseEntity.ok(dipendenti);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }




}
