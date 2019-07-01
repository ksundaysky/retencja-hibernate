package ja.workshops.retencja.hibernate;

import javax.persistence.*;
import java.util.Set;

@Entity
class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String nazwa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marka_id")
    private
    Marka marka;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "auto_id")},
            inverseJoinColumns = {@JoinColumn(name = "projektant_id")}
    )
    private Set<Projektant> projektanci;

    public Auto() {
    }

    Auto(String nazwa, Marka marka, Set<Projektant> projektanci) {
        this.nazwa = nazwa;
        this.marka = marka;
        this.projektanci = projektanci;
    }
}
