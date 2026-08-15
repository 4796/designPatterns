package Observer;

import AbstractProductC.IzvorPodataka;
import DomainClasses.Put;
import DomainClasses.Vozilo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoziloObserver implements Observer { // ConcreteObserver

    private static final int BRZINA_U_ZAGUSENJU = 1;

    private final IzvorPodataka subject;
    private final Map<Vozilo, Integer> originalnaBrzina = new HashMap<>();

    public VoziloObserver(IzvorPodataka subject, List<Put> putevi) {
        this.subject = subject;
        for (Put put : putevi) {
            for (Vozilo v : put.getVozila()) {
                originalnaBrzina.put(v, v.getBrzina());
            }
        }
    }

    @Override
    public void update() {
        for (Put put : subject.getPutevi()) {
            boolean zagusena = subject.jeZagusena(put);
            for (Vozilo v : put.getVozila()) {
                Integer original = originalnaBrzina.get(v);
                if (original == null) {
                    original = v.getBrzina();
                    originalnaBrzina.put(v, original);
                }
                v.setBrzina(zagusena ? BRZINA_U_ZAGUSENJU : original);
            }
        }
    }

}
