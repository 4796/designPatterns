package Observer;

import AbstractProductC.IzvorPodataka;
import DomainClasses.Boja;
import DomainClasses.Put;
import DomainClasses.Semafor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SemaforObserver implements Observer { // ConcreteObserver

    private static final int TRAJANJE_U_ZAGUSENJU = 6;

    private final IzvorPodataka subject;
    private final Map<Semafor, Integer> originalnoTrajanje = new HashMap<>();

    public SemaforObserver(IzvorPodataka subject, List<Semafor> semafori) {
        this.subject = subject;
        for (Semafor s : semafori) {
            originalnoTrajanje.put(s, s.getTrajanjeUKrugovima());
        }
    }

    @Override
    public void update() {
        for (Put put : subject.getPutevi()) {
            Semafor semafor = put.getSledecaRaskrsnica().getSemafor();
            int original = originalnoTrajanje.get(semafor);
            if (subject.jeZagusena(put)) {
                semafor.setTrajanjeUKrugovima(TRAJANJE_U_ZAGUSENJU);
                if (semafor.getBoja() != Boja.ZELENA) {
                    semafor.promeniBoju();
                }
            } else {
                semafor.setTrajanjeUKrugovima(original);
            }
        }
    }

}
