package Handler;

import AbstractProductA.Izvestaj;
import AbstractProductC.IzvorPodataka;


public abstract class Kontroler { // Handler
    protected Izvestaj i;
    protected IzvorPodataka ip;
    protected String poruka;
    protected int brojTrenutnogKruga = 0;
    protected Kontroler sledeci; // successor

    public Kontroler(Izvestaj i1, IzvorPodataka ip1, Kontroler sledeci1) {
        i = i1;
        ip = ip1;
        sledeci = sledeci1;
    }

    public String simulirajJedanKrug() {
        return sledeci.simulirajJedanKrug();
    }

    protected boolean fokusSemafori() {
        return ip.fokusMreza();
    }

}
