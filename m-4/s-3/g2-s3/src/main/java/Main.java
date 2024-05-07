import com.github.javafaker.Faker;
import dao.Event;
import entities.Evento;
import entities.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d12");

        public static void main(String[] args) {
            EntityManager em = emf.createEntityManager();
            Faker faker = new Faker(Locale.ITALY);
            Event eventsDAO = new Event(em);
            Random rndm = new Random();

            for (int i = 0; i < 20; i++) {
                eventsDAO.save(new Evento(
                        faker.chuckNorris().fact(),
                        LocalDate.of(rndm.nextInt(2023, 2025),
                                rndm.nextInt(1, 13),
                                rndm.nextInt(1, 29)),
                        faker.lorem().fixedString(50),
                        rndm.nextInt(1, 3) == 1 ? TipoEvento.PRIVATO : TipoEvento.PUBBLICO,
                        rndm.nextInt(1, 1000)));
            }

            Event found = eventsDAO.getById(6);
            if (found != null)
                System.out.println(found);
            else System.out.println("Elemento non trovato");


            eventsDAO.delete(5);

            em.close();
            emf.close();
        }
    }
}