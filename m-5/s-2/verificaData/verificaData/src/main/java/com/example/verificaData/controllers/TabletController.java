package com.example.verificaData.controllers;


import com.example.verificaData.controllers.records.recordcomplet.TabletRecord;
import com.example.verificaData.data.Tablet;
import com.example.verificaData.services.interfaces.TabletServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tablet")
public class TabletController {

    @Autowired
    private TabletServiceInt tabletService;

    @PostMapping("/aggiungi")
    public ResponseEntity<?> aggiungiTablet(@Validated @RequestBody TabletRecord body, BindingResult validation) {
        if (validation.hasErrors()) {
            return ResponseEntity.badRequest().body("Errore di validazione: " + validation.getAllErrors());
        }

        try {
            Tablet nuovoTablet = tabletService.save(body);
            return ResponseEntity.ok(nuovoTablet);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping("/{tabletid}")
    public ResponseEntity<Tablet> getTabletById(@PathVariable Long id) {
        try {
            Tablet tablet = tabletService.getTabletById(id);
            return ResponseEntity.ok(tablet);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{tabletid}")
    public ResponseEntity<Void> rimuoviTablet(@PathVariable Long id) {
        try {
            tabletService.rimuoviTablet(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{tabletid}")
    public ResponseEntity<Tablet> aggiornaTablet(@PathVariable Long id, @RequestBody TabletRecord body) {
        try {
            Tablet updatedTablet = tabletService.findByIdAndUpdate(id, body);
            return ResponseEntity.ok(updatedTablet);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{tabletId}/assegna/{dipendenteId}")
    public ResponseEntity<Tablet> assegnaTablet(@PathVariable Long tabletId, @PathVariable Long dipendenteId) {
        try {
            Tablet tablet = tabletService.assegnaDispositivo(tabletId, dipendenteId);
            return ResponseEntity.ok(tablet);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<Tablet>> getAllTablets(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size,
                                                      @RequestParam(defaultValue = "id") String sort) {
        try {
            Page<Tablet> tablets = tabletService.getAllTablet(page, size, sort);
            return ResponseEntity.ok(tablets);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
