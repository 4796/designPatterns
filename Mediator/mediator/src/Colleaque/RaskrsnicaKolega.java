package Colleaque;

import DomainClasses.Boja;
import DomainClasses.Raskrsnica;

public class RaskrsnicaKolega extends Colleague { // ConcreteColleague

    private final Raskrsnica raskrsnica;

    public RaskrsnicaKolega(Raskrsnica raskrsnica) {
        this.raskrsnica = raskrsnica;
    }

    public Raskrsnica getRaskrsnica() {
        return raskrsnica;
    }

    public void zatraziPromenu(Boja zeljenaBoja) {
        mediator.zatraziPromenu(this, zeljenaBoja);
    }

    public void postaviBoju(Boja zeljenaBoja) {
        if (raskrsnica.getSemafor().getBoja() != zeljenaBoja) {
            raskrsnica.getSemafor().promeniBoju();
        }
    }

}
