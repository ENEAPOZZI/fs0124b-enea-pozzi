package it.epicode.entities;

import jakarta.persistence.OneToMany;

import java.util.List;

public class Libro extends Elemento {

    protected String autore;
    protected String genere;

    public Libro() {

    }

    @OneToMany(mappedBy = "libro")
    protected List<Prestito> prestiti;

    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine); // richiamo al costruttore del padre
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
