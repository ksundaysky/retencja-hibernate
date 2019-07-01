package ja.workshops.retencja.hibernate;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

class Marka {


    Long id;

    private String nazwa;

    Marka(String nazwa) {
        this.nazwa = nazwa;
    }
}
