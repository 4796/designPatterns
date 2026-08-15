package Decorator;

import Component.Kontroler;

public class DekoratorKontroler extends Kontroler { // Decorator

    protected Kontroler kon;

    public DekoratorKontroler(Kontroler kon1) { kon = kon1; }

    @Override
    public String simulirajJedanKrug() {
        return kon.simulirajJedanKrug();
    }

}
