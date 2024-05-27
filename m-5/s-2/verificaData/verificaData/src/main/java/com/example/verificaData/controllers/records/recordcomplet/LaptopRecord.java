package com.example.verificaData.controllers.records.recordcomplet;

import com.example.verificaData.data.Dipendente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record LaptopRecord(

        @NotNull(message = "Il campo 'id' non può essere vuoto")
        Long id,

        @NotNull(message = "Il campo 'tipo' non può essere vuoto")
        String tipo,

        @NotNull(message = "Il campo 'stato' non può essere vuoto")
        String stato,

        @Valid
        Dipendente dipendente,

        @NotNull(message = "Il campo 'modello' non può essere vuoto")
        String modello,

        @NotNull(message = "Il campo 'sistemaOperativo' non può essere vuoto")
        String sistemaOperativo
) {
}
