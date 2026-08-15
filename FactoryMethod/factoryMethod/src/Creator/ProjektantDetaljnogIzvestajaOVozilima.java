package Creator;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.KompleksanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import AbstractProductC.IzvorPodatakaOVozilima;

public class ProjektantDetaljnogIzvestajaOVozilima extends Projektant {

    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new DetaljanPrikaz();
        IzvestajOVozilima ip = new IzvestajOVozilima(d);
        return ip;
    }

    @Override
    public IzvorPodataka kreirajIzvorPodataka ()
      { IzvorPodataka dbbr = new IzvorPodatakaOVozilima();
        return dbbr;}

    @Override
    public Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip) {
        Kontroler kon = new KompleksanKontroler(i,ip);
        return kon;
    }
        
   
}

