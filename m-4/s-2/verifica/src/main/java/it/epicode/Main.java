package it.epicode;


import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();



        Rivista rivista = new Rivista("456", "ciao", 2020, 50, Periodicita.SEMESTRALE);
        Libro libro = new Libro("56546", "bello", 2000, 58, "michele", "horror");
        Libro libro1 = new Libro("5654846", "ciao", 2100, 78, "luca", "commedia");

        archivio.rimuoviElemento("456");

        // Ricerca per ISBN
        Optional<Object> foundItem = archivio.ricercaPerISBN("56546");
        foundItem.ifPresent(item -> System.out.println("Trovato: " + item));

        // Ricerca per autore
        List<Object> itemsByAuthor = archivio.ricercaPerAutore("michele");
        itemsByAuthor.forEach(System.out::println);
    }


}