package AbstractFactory;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;
import Handler.Kontroler;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import AbstractProductC.IzvorPodatakaOVozilima;
import ConcreteHandler.KompleksanKontroler;
import ConcreteHandler.ValidacijaMreze;
import ConcreteHandler.ValidacijaSemafora;

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
        Kontroler stvarni = new KompleksanKontroler(i,ip);
        Kontroler provereMreze = new ValidacijaMreze(ip, stvarni);
        Kontroler provereSemafora = new ValidacijaSemafora(ip, provereMreze);
        return provereSemafora;
    }

}
