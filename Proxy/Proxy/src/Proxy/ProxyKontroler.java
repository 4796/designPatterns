package Proxy;

import Subject.Kontroler;

public class ProxyKontroler extends Kontroler { // Proxy

    private static final int MAX_KRUGOVA = 5;

    protected Kontroler kon;

    public ProxyKontroler(Kontroler kon1) { kon = kon1; }

    @Override
    public String simulirajJedanKrug() {
        if (brojTrenutnogKruga >= MAX_KRUGOVA) {
            return "Zastita: dostignut je maksimalan broj krugova simulacije (" + MAX_KRUGOVA + "). Dalje simuliranje nije dozvoljeno.\n";
        }
        brojTrenutnogKruga++;
        return kon.simulirajJedanKrug();
    }

}
