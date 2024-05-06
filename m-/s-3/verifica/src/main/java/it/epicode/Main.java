package it.epicode;

import it.epicode.dao.BiblioDao;
import it.epicode.entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
// non sono riuscito a trovare l'errore dopo varie ricerche di tutti gli errori mi dicono che sono errori di conessione al server
public class Main {
    public static void main(String[] args) {

        BiblioDao dao = new BiblioDao();

        // Creazione di un utente
        Utente utente = new Utente("123456", "Mario", "Rossi", new Date("01/01/1990"));
        dao.aggiungiUtente(utente);

        // Creazione di un libro
        Libro libro = new Libro("978-8804668237", "Il nome della rosa", 1980, 512, "Umberto Eco", "Romanzo storico");
        dao.aggiungiElemento(libro);

        // Creazione di una rivista
        Rivista rivista = new Rivista("977-0399523821", "National Geographic", 1888, 100, "Mensile");
        dao.aggiungiElemento(rivista);

    

        // Ricerca per ISBN
        System.out.println("\nRicerca per ISBN:");
        Elemento elementoByISBN = dao.ricercaPerISBN("978-8804668237");
        System.out.println(elementoByISBN);

        // Ricerca per autore
        System.out.println("\nRicerca per autore:");
        List<Elemento> elementiByAutore = dao.ricercaPerAutore("Umberto Eco");
        elementiByAutore.forEach(System.out::println);

        // Ricerca per titolo
        System.out.println("\nRicerca per titolo:");
        List<Elemento> elementiByTitolo = dao.ricercaPerTitolo("National Geographic");
        elementiByTitolo.forEach(System.out::println);

        // Ricerca prestiti di un utente
        System.out.println("\nRicerca prestiti dell'utente:");
        List<Prestito> prestitiUtente = dao.ricercaPrestitiUtente("123456");
        prestitiUtente.forEach(System.out::println);

        // Ricerca prestiti scaduti e restituiti
        System.out.println("\nRicerca prestiti scaduti e restituiti:");
        List<Prestito> prestitiScadutiERestituiti = dao.ricercaPrestitiScadutiERestituiti();
        prestitiScadutiERestituiti.forEach(System.out::println);

        // Rimozione di un elemento
        dao.rimuoviElemento("977-0399523821");

        dao.close();
    }




}
