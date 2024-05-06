package it.epicode.entities;

import jakarta.persistence.OneToMany;

import java.util.List;

public class Rivista extends Elemento {


    protected String periodicita;


    @OneToMany(mappedBy = "rivitsa")
    protected List<Prestito> prestiti;

    public Rivista() {

    }

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String periodicità) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);// richiamo al costruttore del padre
        this.periodicita = periodicità;
    }

    public String getPeriodicità() {
        return periodicita;
    }

    public void setPeriodicità(String periodicità) {
        this.periodicita = periodicita;
    }
}
