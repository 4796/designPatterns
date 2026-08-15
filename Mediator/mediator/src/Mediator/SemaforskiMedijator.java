package Mediator;

import Colleaque.Colleague;
import Colleaque.RaskrsnicaKolega;
import DomainClasses.Boja;

public class SemaforskiMedijator implements Mediator { // ConcreteMediator

    private final RaskrsnicaKolega k1;
    private final RaskrsnicaKolega k2;
    private final RaskrsnicaKolega k3;
    private final RaskrsnicaKolega k4;

    public SemaforskiMedijator(RaskrsnicaKolega k1, RaskrsnicaKolega k2, RaskrsnicaKolega k3, RaskrsnicaKolega k4) {
        this.k1 = k1;
        this.k2 = k2;
        this.k3 = k3;
        this.k4 = k4;
    }

    @Override
    public void zatraziPromenu(Colleague posiljalac, Boja zeljenaBoja) {
        for (RaskrsnicaKolega k : new RaskrsnicaKolega[]{k1, k2, k3, k4}) {
            if (k == posiljalac) {
                k.postaviBoju(zeljenaBoja);
            } else {
                k.postaviBoju(Boja.CRVENA);
            }
        }
    }

}
