package ja.workshops.retencja.hibernate;

import javax.persistence.*;
import java.util.Set;

@Entity
class Projektant {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String nazwa;

    @ManyToMany(mappedBy = "projektanci")
    Set<Auto> auta;

    public Projektant() {
    }

    public Projektant(String nazwa) {
        this.nazwa = nazwa;
    }
}

