package Observer;

import AbstractProductC.IzvorPodataka;
import DomainClasses.Put;
import java.util.HashSet;
import java.util.Set;

public class ZagusenjeIspisObserver implements Observer { // ConcreteObserver

    private final IzvorPodataka subject;
    private final Set<Put> trenutnoZagusene = new HashSet<>();

    public ZagusenjeIspisObserver(IzvorPodataka subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        for (Put put : subject.getPutevi()) {
            boolean zagusenaSada = subject.jeZagusena(put);
            boolean bilaZagusena = trenutnoZagusene.contains(put);

            if (zagusenaSada && !bilaZagusena) {
                System.out.println("!! ZAGUSENJE: " + put.getNaziv() + " ima " + put.getVozila().size()
                        + " vozila (prag " + IzvorPodataka.PRAG_ZAGUSENJA + ") - semafor produzen, vozila usporena.");
                trenutnoZagusene.add(put);
            } else if (!zagusenaSada && bilaZagusena) {
                System.out.println("-- ZAGUSENJE RESENO: " + put.getNaziv() + " se vratila na normalan protok.");
                trenutnoZagusene.remove(put);
            }
        }
    }

}
