package it.epicode.dao;

import it.epicode.entities.*;
import jakarta.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Date;
import java.util.List;

public class BiblioDao {

    private static final Logger log = LoggerFactory.getLogger(BiblioDao.class);
    private static final String PERSISTENCE_UNIT = "Library";
    private EntityManagerFactory emf;
    private EntityManager em;


    // Creazione dell'EntityManagerFactory e dell'EntityManager
    public BiblioDao() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emf.createEntityManager();
    }

    // Chiudi l'EntityManager e l'EntityManagerFactory
    public void close() {

        em.close();
        emf.close();
    }

    // Aggiungi un elemento (libro o rivista)
    public void aggiungiElemento(Elemento elemento) {
        // Inizio una transazione
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            // Persisti l'elemento nel database
            em.persist(elemento);
            // Commit della transazione
            trans.commit();
            // Log dell'elemento aggiunto con successo
            log.info("Elemento aggiunto con successo: " + elemento);
        } catch (Exception e) {
            // Se la transazione è attiva, quindi non è andata  effettua il rollback
            if (trans.isActive()) {
                trans.rollback();
            }
            // Log dell'errore durante l'aggiunta dell'elemento
            log.error("Errore durante l'aggiunta dell'elemento: " + e.getMessage());
        }
    }

    // Rimuovi un elemento dato il suo codice ISBN
    public void rimuoviElemento(String isbn) {
        // Inizia una transazione
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            // Trova l'elemento nel database tramite il suo ISBN
            Elemento elemento = em.find(Elemento.class, isbn);
            if (elemento != null) {
                // Rimuovi l'elemento dal database
                em.remove(elemento);
                // Log dell'elemento rimosso con successo
                log.info("Elemento rimosso con successo: " + elemento);
            }
            trans.commit();
        } catch (Exception e) {
            // Se la transazione è attiva, effettua il rollback
            if (trans.isActive()) {
                trans.rollback();
            }
            log.error("Errore durante la rimozione dell'elemento: " + e.getMessage());
        }
    }

    // Ricerca un elemento per ISBN
    public Elemento ricercaPerISBN(String isbn) {
        // Trova l'elemento nel database tramite il suo ISBN
        return em.find(Elemento.class, isbn);
    }

    // Ricerca elementi per autore
    public List<Elemento> ricercaPerAutore(String autore) {
        // query per trovare gli elementi con l'autore specificato
        TypedQuery<Elemento> query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.autore = :autore", Elemento.class);
        // Imposta il parametro autore nella query con il valore fornito
        query.setParameter("autore", autore);
        // Esegue la query e restituisce la lista di elementi trovati
        return query.getResultList();
    }

    // Ricerca elementi per titolo
    public List<Elemento> ricercaPerTitolo(String titolo) {
        // Esegue una query per trovare gli elementi con il titolo specificato
        TypedQuery<Elemento> query = em.createQuery(
                "SELECT e FROM Elemento e WHERE e.titolo = :titolo", Elemento.class);
        query.setParameter("titolo", titolo);
        return query.getResultList();
    }

    // Ricerca prestiti di un utente dato il suo numero di tessera
    public List<Prestito> ricercaPrestitiUtente(String numeroTessera) {
        // Esegue una query per trovare i prestiti dell'utente con il numero di tessera specificato
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera", Prestito.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    // Ricerca prestiti scaduti e restituiti
    public List<Prestito> ricercaPrestitiScadutiERestituiti() {
        // Esegue una query per trovare i prestiti scaduti e restituiti
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.dataRestituzione IS NOT NULL " +
                        "AND p.dataRestituzione > :dataScadenza", Prestito.class);
        query.setParameter("dataScadenza", new Date());
        return query.getResultList();
    }

    public void aggiungiUtente(Utente utente) {
        EntityTransaction trans = em.getTransaction();
        try {
            // Inizio la transazione
            trans.begin();
            // Persisti l'utente nel database
            em.persist(utente);
            // Commit della transazione
            trans.commit();
        } catch (Exception e) {
            // Se la transazione è attiva, effettua il rollback
            if (trans.isActive()) {
                trans.rollback();
            }
            // Stampa l'errore
            e.printStackTrace();
        }
    }



    public void aggiungiPrestito(Prestito prestito) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(prestito);
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
    }




}
