package ja.workshops.retencja.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        Session session = H2Connector.getSessionFactory().getCurrentSession();


        //TODO: W tym miejscu rozpoczynamy transakcję, spróbuj zakomentować rozpoczęcie transakcji i zaobserwuj zmiany
        Transaction transaction = session.beginTransaction();

        Projektant projektant = new Projektant("Janek");
        Projektant projektant1 = new Projektant("Sławula");
        Projektant projektant2 = new Projektant("Mieciu");

        Marka marka = new Marka("Audi");
        Marka świdrowiatrak = new Marka("świdrowiatrak");
        Marka abrakadabra = new Marka("abrakadabra");

        Auto auto = new Auto("A4",marka, Set.of(projektant1,projektant2,projektant));
        Auto auto2 = new Auto("superhiper",świdrowiatrak, Set.of(projektant2,projektant));
        Auto auto3 = new Auto("czarodziej",abrakadabra, Set.of(projektant));

        // TODO: metoda save(obj) służy do zapisu danych do bazy, w następnym zadaniu wykorzystamy inne metody takie jak saveOrUpdate, remove ...
        session.save(auto);
        session.save(auto2);
        session.save(auto3);

        //TODO: W tym miejscu kończymy transakcję, spróbuj zakomentować zakończenie transakcji i zaobserwuj zmiany, co znajduje się w bazie
        transaction.commit();
    }
}
