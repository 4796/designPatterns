package AbstractFactory;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.KompleksanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import AbstractProductC.IzvorPodatakaOVozilima;
import ConcreteCommand.SO;
import java.util.Scanner;

public class ProjektantDetaljnogIzvestajaOVozilima implements Projektant {

    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new DetaljanPrikaz();
        IzvestajOVozilima i = new IzvestajOVozilima(d);
        return i;
    }

    @Override
    public IzvorPodataka kreirajIzvorPodataka ()
      { IzvorPodataka ip = new IzvorPodatakaOVozilima();
        return ip;}

    @Override
    public Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip) {
        Kontroler kon = new KompleksanKontroler(i,ip);
        return kon;
    }

    @Override
    public void povezi(IzvorPodataka ip, Scanner unos) {
        SO so = new SO();
        ip.povezi(so, unos);
    }

}
