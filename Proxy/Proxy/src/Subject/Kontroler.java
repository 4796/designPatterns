package Subject;

import AbstractProductA.Izvestaj;
import AbstractProductC.IzvorPodataka;


public abstract class Kontroler { // Subject
    protected Izvestaj i;
    protected IzvorPodataka ip;
    protected String poruka;
    protected int brojTrenutnogKruga = 0;

    public abstract String simulirajJedanKrug();

    protected boolean fokusSemafori() {
        return ip.fokusMreza();
    }

}
