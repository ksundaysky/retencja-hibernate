package ja.workshops.retencja.hibernate;

import java.util.Set;

class Auto {

    Long id;

    private String nazwa;

    private
    Marka marka;

    private
    Set<Projektant> projektanci;

    Auto(String nazwa, Marka marka, Set<Projektant> projektanci) {
        this.nazwa = nazwa;
        this.marka = marka;
        this.projektanci = projektanci;
    }
}
