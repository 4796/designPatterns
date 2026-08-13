package AbstractProductD;

import AbstractProductA.Izvestaj;
import Abstraction.IzvorPodataka;


public abstract class Kontroler {
    Izvestaj i;
    IzvorPodataka ip;
    String poruka;
    protected int brojTrenutnogKruga = 0;

    public abstract String simulirajJedanKrug();

    protected boolean fokusSemafori() {
        return ip.fokusMreza();
    }

}
