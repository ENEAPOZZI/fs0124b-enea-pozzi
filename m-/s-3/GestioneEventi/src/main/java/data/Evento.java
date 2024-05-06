package main.java.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "evento")

public class Evento {



    @Id // identifica la chiave della tabella
    private long id;
    @Column(name = "titolo", length = 25, nullable = false)
    private String titolo;

    @Column(name = "data_evento", columnDefinition = "character varying(25)", nullable = true)
    private String data;

    @Column(length = 15, name = "descrizione")
    private String descrizione;

    @Column(length = 15, name = "tipo")
    private String tipo;

    @Column(length = 15, name = "numero")
    private Integer nmax;


    public Evento() {
    }

    public Evento(String data, String descrizione, long id, Integer nmax, String tipo, String titolo) {
        this.data = data;
        this.descrizione = descrizione;
        this.id = id;
        this.nmax = nmax;
        this.tipo = tipo;
        this.titolo = titolo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getNmax() {
        return nmax;
    }

    public void setNmax(Integer nmax) {
        this.nmax = nmax;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}

