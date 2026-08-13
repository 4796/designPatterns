package AbstractFactory;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;
import ConcreteComponent.KompleksanKontroler;
import Component.Kontroler;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import AbstractProductC.IzvorPodatakaOVozilima;
import ConcreteDecorators.KonkretniDekoratorKontroleraA;
import ConcreteDecorators.KonkretniDekoratorKontroleraB;

public class ProjektantDetaljnogIzvestajaOVozilima implements Projektant {

    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new DetaljanPrikaz();
        IzvestajOVozilima i = new IzvestajOVozilima(d);
        return i;
    }

    @Override
    public IzvorPodataka kreirajIzvorPodataka ()
      { IzvorPodataka dbbr = new IzvorPodatakaOVozilima();
        return dbbr;}

    @Override
    public Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip) {
        Kontroler kon = new KompleksanKontroler(i,ip);
        Kontroler dekorisanoA = new KonkretniDekoratorKontroleraA(kon);
        Kontroler dekorisanoAB = new KonkretniDekoratorKontroleraB(dekorisanoA);
        return dekorisanoAB;
    }

}
