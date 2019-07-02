# Dostosowane zapytania - Hibernate

W ćwiczeniu wykonasz zapytania na 3 różne sposoby poprzez:

* Zwykły SQL
* HQL 
* NamedQuery

Zwykły SQL to po prostu string z kwerendą, operujesz na nazwach takich jak w bazie danych

HQL - Hibernate Query Language - jest to język zapytań, który wywodzi się od JPQL (Java Persistence Query Language) odnosimy się do klas modelowych nie bezpośrednio do tabel w bazie.

NamedQuery - opiera sie na zasadzie HQL, definiujemy jednak kwerendy w klasie encji i odnosimy się do nich poprzez nazwy stąd NamedQuery

*Pomocne podczas wykonywania zadania będą metody klasy session: createQuery() oraz createSqlQuery()*


W klasei App znajdują się trzy statyczne metody które implementują odpowiednie kwerendy 

Jest to ostatnie zadanie, moje rozwiązanie znajduje sie na kolejnej gałęzi:

*git checkout rozwiązanie*
