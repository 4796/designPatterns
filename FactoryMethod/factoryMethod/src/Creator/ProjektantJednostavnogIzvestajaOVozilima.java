package Creator;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;
import AbstractProductC.IzvorPodatakaOVozilima;
import AbstractProductD.JednostavanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;

public class ProjektantJednostavnogIzvestajaOVozilima extends Projektant {

    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new JednostavanPrikaz();
        IzvestajOVozilima ip = new IzvestajOVozilima(d);
        return ip;
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

