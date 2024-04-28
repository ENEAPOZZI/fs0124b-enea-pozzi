package it.epicode;


import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Archivio {


    private final List<Object> elements = new ArrayList<>();
    private static final String STORAGE = "./archivio4.my";


    public void aggiungiElemento(Object elemento) {
        elements.add(elemento);
    }

    public void rimuoviElemento(String codiceISBN) {
        elements.removeIf(obj -> {
            if (obj instanceof Libro) {
                return ((Libro) obj).getCodiceISBN().equals(codiceISBN);
            } else if (obj instanceof Rivista) {
                return ((Rivista) obj).getCodiceISBN().equals(codiceISBN);
            }
            return false;
        });
    }

    public Optional<Object> ricercaPerISBN(String codiceISBN) {
        return elements.stream()
                .filter(obj -> {
                    if (obj instanceof Libro) {
                        return ((Libro) obj).getCodiceISBN().equals(codiceISBN);
                    } else if (obj instanceof Rivista) {
                        return ((Rivista) obj).getCodiceISBN().equals(codiceISBN);
                    }
                    return false;
                })
                .findFirst();
    }

    public List<Object> ricercaPerAutore(String autore) {
        return elements.stream()
                .filter(obj -> obj instanceof Libro)
                .map(obj -> (Libro) obj)
                .filter(libro -> libro.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
    }



}

