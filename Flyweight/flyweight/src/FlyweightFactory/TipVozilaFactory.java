package FlyweightFactory;

import Flyweight.TipVozila;
import Flyweight.TipVozilaDeljeni;
import java.util.HashMap;
import java.util.Map;

public class TipVozilaFactory { // FlyweightFactory

    private final Map<String, TipVozila> tipovi = new HashMap<>();

    public TipVozila dohvatiTipVozila(String marka, String model, int brzina) {
        String kljuc = marka + "|" + model + "|" + brzina;
        TipVozila tip = tipovi.get(kljuc);
        if (tip == null) {
            tip = new TipVozilaDeljeni(marka, model, brzina);
            tipovi.put(kljuc, tip);
        }
        return tip;
    }

    public int getBrojDeljenihTipova() {
        return tipovi.size();
    }

}
