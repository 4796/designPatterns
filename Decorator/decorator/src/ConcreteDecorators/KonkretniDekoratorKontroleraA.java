package ConcreteDecorators;

import Component.Kontroler;
import Decorator.DekoratorKontroler;

public class KonkretniDekoratorKontroleraA extends DekoratorKontroler { // ConcreteDecoratorA

    // Dodaje se novo stanje postojecim stanjima: brojac koliko puta je krug simuliran.
    private int brojPoziva = 0;

    public KonkretniDekoratorKontroleraA(Kontroler osnovni) {
        super(osnovni);
    }

    @Override
    public String simulirajJedanKrug() {
        brojPoziva++;
        String izvestaj = super.simulirajJedanKrug();
        return izvestaj + "  [Dekorator A] Broj pokrenutih krugova: " + brojPoziva + "\n";
    }

}
