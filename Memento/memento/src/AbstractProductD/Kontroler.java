package AbstractProductD;

import AbstractProductA.Izvestaj;
import AbstractProductC.IzvorPodataka;
import Memento.Memento;
import java.util.ArrayDeque;
import java.util.Deque;


public abstract class Kontroler { // Caretaker
    Izvestaj i;
    IzvorPodataka ip;
    String poruka;
    protected int brojTrenutnogKruga = 0;
    private final Deque<Memento> istorija = new ArrayDeque<>();

    public abstract String simulirajJedanKrug();

    protected boolean fokusSemafori() {
        return ip.fokusMreza();
    }

    public void sacuvajTrenutnoStanje() {
        istorija.push(ip.sacuvajStanje());
    }

    public String vratiPrethodniKrug() {
        if (istorija.isEmpty()) {
            return "Nema prethodnog kruga za povratak.";
        }
        ip.vratiStanje(istorija.pop());
        if (brojTrenutnogKruga > 0) {
            brojTrenutnogKruga--;
        }
        return "Vraceno na stanje pre kruga " + (brojTrenutnogKruga + 1) + ".";
    }

}
