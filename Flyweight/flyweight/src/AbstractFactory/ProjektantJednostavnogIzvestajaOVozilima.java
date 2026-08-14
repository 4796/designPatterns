package AbstractFactory;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;
import AbstractProductC.IzvorPodatakaOVozilima;
import AbstractProductD.JednostavanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;

public class ProjektantJednostavnogIzvestajaOVozilima implements Projektant {

    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new JednostavanPrikaz();
        IzvestajOVozilima i = new IzvestajOVozilima(d);
        return i;
    }

    @Override
    public IzvorPodataka kreirajIzvorPodataka ()
      { IzvorPodataka dbbr = new IzvorPodatakaOVozilima();
        return dbbr;}

    @Override
    public Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip) {
        Kontroler kon = new JednostavanKontroler(i,ip);
        return kon;
    }

}
