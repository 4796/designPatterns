package Creator;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodatakaOMrezi;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.JednostavanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;

public class ProjektantJednostavnogIzvestajaOMrezi extends Projektant {

    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new JednostavanPrikaz();
        IzvestajOMrezi ip = new IzvestajOMrezi(d);
        return ip;
    }

    @Override
    public IzvorPodataka kreirajIzvorPodataka ()
      { IzvorPodataka dbbr = new IzvorPodatakaOMrezi();
        return dbbr;}

    @Override
    public Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip) {
        Kontroler kon = new JednostavanKontroler(i,ip);
        return kon;
    }
        
   
}

