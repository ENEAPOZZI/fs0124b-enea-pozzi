package it.epicode;


import java.io.Serializable;

public class Rivista extends General  implements Serializable {

    private String periodicita;

    public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicità) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    // Metodi getter e setter per l'attributo aggiuntivo

    public String getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(String periodicità) {
        this.periodicita = periodicita;
    }

}
