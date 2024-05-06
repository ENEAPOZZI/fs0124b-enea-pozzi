package it.epicode.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id generato in auto con incremento
    protected Long id;
    protected Date dataInizio;
    protected Date dataRestituzione;


    @ManyToOne
    protected Libro libro;

    @ManyToOne
    protected Rivista rivista;

    public Prestito() {

    }

    public Prestito(Libro libro, Rivista rivista, Date dataInizio) {
        this.libro = libro;
        this.rivista = rivista;
        this.dataInizio = dataInizio;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(Date dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Rivista getRivista() {
        return rivista;
    }

    public void setRivista(Rivista rivista) {
        this.rivista = rivista;
    }
}
