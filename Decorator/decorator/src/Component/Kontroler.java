package Component;

import AbstractProductA.Izvestaj;
import AbstractProductC.IzvorPodataka;


public abstract class Kontroler { // Component
    protected Izvestaj i;
    protected IzvorPodataka ip;
    protected String poruka;
    protected int brojTrenutnogKruga = 0;

    public abstract String simulirajJedanKrug();

    protected boolean fokusSemafori() {
        return ip.fokusMreza();
    }

}
