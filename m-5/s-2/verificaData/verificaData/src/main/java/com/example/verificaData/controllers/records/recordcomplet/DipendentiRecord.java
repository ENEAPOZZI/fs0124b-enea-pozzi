    package com.example.verificaData.controllers.records.recordcomplet;

    import com.example.verificaData.data.Dispositivo;
    import jakarta.validation.Valid;
    import jakarta.validation.constraints.Email;
    import jakarta.validation.constraints.NotNull;

    import java.util.List;

    public record DipendentiRecord(

            @NotNull(message = "Il campo 'username' non può essere vuoto")
             String username,

            @NotNull(message = "Il campo 'nome' non può essere vuoto")
             String nome,

            @NotNull(message = "Il campo 'cognome' non può essere vuoto")
             String cognome,

            @NotNull(message = "Il campo 'email' non può essere vuoto")
            @Email(message = "Il campo 'email' deve essere un indirizzo email valido")
             String email,

             @Valid
             List<Dispositivo> dispositiviAssegnati


    ) {
    }
