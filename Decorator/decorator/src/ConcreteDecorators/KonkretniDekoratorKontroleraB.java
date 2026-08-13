package ConcreteDecorators;

import Component.Kontroler;
import Decorator.DekoratorKontroler;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KonkretniDekoratorKontroleraB extends DekoratorKontroler { // ConcreteDecoratorB

    // Dodaje se novo ponasanje postojecem ponasanju: ispis trenutnog vremena i dana.
    private static final String[] DANI = {
        "ponedeljak", "utorak", "sreda", "cetvrtak", "petak", "subota", "nedelja"
    };
    private static final DateTimeFormatter FORMAT_VREMENA = DateTimeFormatter.ofPattern("HH:mm:ss");

    public KonkretniDekoratorKontroleraB(Kontroler osnovni) {
        super(osnovni);
    }

    @Override
    public String simulirajJedanKrug() {
        String izvestaj = super.simulirajJedanKrug();
        LocalDateTime sada = LocalDateTime.now();
        String dan = DANI[sada.getDayOfWeek().getValue() - 1];
        return izvestaj + "  [Dekorator B] Vreme simulacije: " + sada.format(FORMAT_VREMENA) + ", " + dan + "\n";
    }

}
