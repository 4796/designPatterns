package AbstractFactory;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodatakaOMrezi;
import AbstractProductC.IzvorPodataka;
import ConcreteComponent.JednostavanKontroler;
import Component.Kontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;
import ConcreteDecorators.KonkretniDekoratorKontroleraA;
import ConcreteDecorators.KonkretniDekoratorKontroleraB;

public class ProjektantJednostavnogIzvestajaOMrezi implements Projektant {

    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new JednostavanPrikaz();
        IzvestajOMrezi i = new IzvestajOMrezi(d);
        return i;
    }

    @Override
    public IzvorPodataka kreirajIzvorPodataka ()
      { IzvorPodataka dbbr = new IzvorPodatakaOMrezi();
        return dbbr;}

    @Override
    public Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip) {
        Kontroler kon = new JednostavanKontroler(i,ip);
        Kontroler dekorisanoA = new KonkretniDekoratorKontroleraA(kon);
        Kontroler dekorisanoAB = new KonkretniDekoratorKontroleraB(dekorisanoA);
        return dekorisanoAB;
    }

}
