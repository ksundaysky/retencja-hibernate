package ja.workshops.retencja.hibernate;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
class Marka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String nazwa;

    @OneToMany(mappedBy = "marka")
    Set<Auto> auta = new HashSet<>();

    public Marka() {
    }

    Marka(String nazwa) {
        this.nazwa = nazwa;
    }
}