package Colleaque;

import DomainClasses.Vozilo;

public class VoziloKolega extends Colleague { // ConcreteColleague

    private static final int MAX_DUZINA_KORIDORA = 4;

    private final Vozilo vozilo;

    public VoziloKolega(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void pripremiKrug() {
        int duzina = Math.min(vozilo.getBrzina(), MAX_DUZINA_KORIDORA);
        mediator.zatraziKoridor(vozilo.getPut().getSledecaRaskrsnica(), duzina);
    }

}
