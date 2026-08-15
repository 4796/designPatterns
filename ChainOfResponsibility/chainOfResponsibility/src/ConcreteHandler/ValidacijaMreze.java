package ConcreteHandler;

import AbstractProductC.IzvorPodataka;
import DomainClasses.Put;
import DomainClasses.Raskrsnica;
import Handler.Kontroler;

public class ValidacijaMreze extends Kontroler { // ConcreteHandler (provera strukturnog integriteta mreze)

    public ValidacijaMreze(IzvorPodataka ip1, Kontroler sledeci1) { super(null, ip1, sledeci1); }

    @Override
    public String simulirajJedanKrug() {
        if (ip.getPutevi().isEmpty()) {
            return "Krug nije simuliran: mreza ne sadrzi nijednu ulicu.\n";
        }
        for (Put put : ip.getPutevi()) {
            Raskrsnica r = put.getSledecaRaskrsnica();
            if (r == null || r.getNaredniPut() == null) {
                return "Krug nije simuliran: mreza sadrzi nepovezanu raskrsnicu (" + put.getNaziv() + ").\n";
            }
        }
        return sledeci.simulirajJedanKrug();
    }

}
