package ja.workshops.retencja.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Session session = H2Connector.getSessionFactory().getCurrentSession();


        // W tym miejscu rozpoczynamy transakcję, spróbuj zakomentować rozpoczęcie transakcji i zaobserwuj zmiany
        Transaction transaction = session.beginTransaction();

        Projektant projektant = new Projektant("Janek");
        Projektant projektant1 = new Projektant("Sławula");
        Projektant projektant2 = new Projektant("Mieciu");

        Marka marka = new Marka("Audi");
        Marka świdrowiatrak = new Marka("świdrowiatrak");
        Marka abrakadabra = new Marka("abrakadabra");

        Auto auto = new Auto("A4", marka, Set.of(projektant1, projektant2, projektant));
        Auto auto2 = new Auto("superhiper", świdrowiatrak, Set.of(projektant2, projektant));
        Auto auto3 = new Auto("czarodziej", abrakadabra, Set.of(projektant));

        //  metoda save(obj) służy do zapisu danych do bazy, w następnym zadaniu wykorzystamy inne metody takie jak saveOrUpdate, remove ...
        session.save(auto);
        session.save(auto2);
        session.save(auto3);

        // W tym miejscu kończymy transakcję, spróbuj zakomentować zakończenie transakcji i zaobserwuj zmiany, co znajduje się w bazie
        transaction.commit();

        //  Usuń auto o id 1 i  zamień markę samochodu superhiper na abrakadabra :)
        session = H2Connector.getSessionFactory().getCurrentSession(); //pobieranie obiektu sesji
        // w tym miejscu rozpocznij transakcję

        transaction = session.beginTransaction();
        ja.workshops.retencja.hibernate.Auto kasacja = new ja.workshops.retencja.hibernate.Auto();
        kasacja.id = 1l;
        ja.workshops.retencja.hibernate.Auto superhiper = new ja.workshops.retencja.hibernate.Auto("superhiper", abrakadabra, Set.of(projektant2, projektant));
        superhiper.id = 6l;
        session.delete(kasacja);
        session.saveOrUpdate(superhiper);

        // zatwierdz zaminy
        transaction.commit();
        session = H2Connector.getSessionFactory().getCurrentSession();
        session.beginTransaction();
//        uncomment to test:
//        System.out.println(sqlQueryAllProjektanciStartsWithJ(session));
//        System.out.println(namedQueryAllMarkaStartsWithś(session));
//        System.out.println(hqlQueryAutoNazwaContainsE(session));
        session.getTransaction().commit();


    }


    // Zaimplementuj sql query, ktore znajdzie wszystkich projektantow ktorych imie zaczyna sie na J
    private static List<String> sqlQueryAllProjektanciStartsWithJ(Session session) {
        List<Object> result = session.createSQLQuery("SELECT NAZWA FROM PROJEKTANT WHERE NAZWA LIKE 'J%'").list();
        return result.stream().map(p -> p.toString()).collect(Collectors.toList());
    }

    // Zaimplementuj named query w klasie Marka, skorzystaj z adnotacji NamedQueries oraz NamedQuery
    // z pakietu org.hibernate.annotations
    // kwerenda powinna zwracać listę wszystkich marek, które rozpoczynają się ś
    private static List<Marka> namedQueryAllMarkaStartsWithś(Session session) {
        return session.createNamedQuery("wyszukiwanie").getResultList();
    }

    // Napisz zapytanie w języku hql które zwróci wszystkie auta które w nazwie mają literkę e
    private static List<Auto> hqlQuery(Session session) {
        return session.createQuery("from Auto a Where nazwa like '%e%' ").getResultList();
    }


}
