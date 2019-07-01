package ja.workshops.retencja.hibernate;

import javax.persistence.*;
import java.util.Set;


class Projektant {


    Long id;

    String nazwa;

    Set<Auto> auta;

    Projektant(String nazwa) {
        this.nazwa = nazwa;
    }
}
