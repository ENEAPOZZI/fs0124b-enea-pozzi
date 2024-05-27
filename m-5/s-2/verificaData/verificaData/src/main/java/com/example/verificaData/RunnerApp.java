package com.example.verificaData;


import com.example.verificaData.data.Dipendente;
import com.example.verificaData.data.Laptop;
import com.example.verificaData.data.Smartphone;
import com.example.verificaData.data.Tablet;
import com.example.verificaData.entities.DipendenteRepository;
import com.example.verificaData.entities.LaptopRepository;
import com.example.verificaData.entities.SmartphoneRepository;
import com.example.verificaData.entities.TabletRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class RunnerApp  implements CommandLineRunner {

        @Autowired
        DipendenteRepository dipendenterepository;

        @Autowired
        LaptopRepository laptopRepository;

        @Autowired
        SmartphoneRepository smartphoneRepository;

        @Autowired
        TabletRepository tabletRepository;

    @Override
    public void run(String... args) throws Exception {



            Dipendente dipendente1 = Dipendente.builder()
                    .withUsername("user1")
                    .withNome("Nome1")
                    .withCognome("Cognome1")
                    .withEmail("email1@example.com")
                    .build();

            Dipendente dipendente2 = Dipendente.builder()
                    .withUsername("user2")
                    .withNome("Nome2")
                    .withCognome("Cognome2")
                    .withEmail("email2@example.com")
                    .build();

            dipendenterepository.save(dipendente1);
            dipendenterepository.save(dipendente2);

            Laptop laptop1 = Laptop.builder()
                    .withTipo("Tipo1")
                    .withStato("Disponibile")
                    .withDipendente(dipendente1)
                    .withModello("Modello1")
                    .withSistemaOperativo("Windows")
                    .build();

            Laptop laptop2 = Laptop.builder()
                    .withTipo("Tipo2")
                    .withStato("Disponibile")
                    .withDipendente(dipendente2)
                    .withModello("Modello2")
                    .withSistemaOperativo("MacOS")
                    .build();

            laptopRepository.save(laptop1);
            laptopRepository.save(laptop2);

            Smartphone smartphone1 = Smartphone.builder()
                    .withTipo("Tipo1")
                    .withStato("Disponibile")
                    .withDipendente(dipendente1)
                    .withModello("Modello1")
                    .withSistemaOperativo("Android")
                    .build();

            Smartphone smartphone2 = Smartphone.builder()
                    .withTipo("Tipo2")
                    .withStato("Disponibile")
                    .withDipendente(dipendente2)
                    .withModello("Modello2")
                    .withSistemaOperativo("iOS")
                    .build();

            smartphoneRepository.save(smartphone1);
            smartphoneRepository.save(smartphone2);

            Tablet tablet1 = Tablet.builder()
                    .withTipo("Tipo1")
                    .withStato("Disponibile")
                    .withDipendente(dipendente1)
                    .withModello("Modello1")
                    .withSistemaOperativo("Android")
                    .build();

            Tablet tablet2 = Tablet.builder()
                    .withTipo("Tipo2")
                    .withStato("Disponibile")
                    .withDipendente(dipendente2)
                    .withModello("Modello2")
                    .withSistemaOperativo("iOS")
                    .build();

            tabletRepository.save(tablet1);
            tabletRepository.save(tablet2);



    }
}
