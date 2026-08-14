package ConcreteHandler;

import AbstractProductC.IzvorPodataka;
import DomainClasses.Semafor;
import Handler.Kontroler;

public class ValidacijaSemafora extends Kontroler { // ConcreteHandler (provera formata podataka)

    public ValidacijaSemafora(IzvorPodataka ip1, Kontroler sledeci1) { super(null, ip1, sledeci1); }

    @Override
    public String simulirajJedanKrug() {
        for (Semafor semafor : ip.getSemafori()) {
            if (semafor.getTrajanjeUKrugovima() <= 0) {
                return "Krug nije simuliran: semafor ima nevalidno trajanje (" + semafor.getTrajanjeUKrugovima() + ").\n";
            }
        }
        return sledeci.simulirajJedanKrug();
    }

}
