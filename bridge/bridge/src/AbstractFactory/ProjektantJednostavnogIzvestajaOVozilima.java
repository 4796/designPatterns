package AbstractFactory;

import AbstractProductB.Detaljnost;
import RefinedAbstraction.IzvorPodatakaOVozilima1;
import AbstractProductD.JednostavanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;
import java.util.Scanner;

public class ProjektantJednostavnogIzvestajaOVozilima extends Projektant {

    public ProjektantJednostavnogIzvestajaOVozilima(Scanner unos) { super(unos); }

   @Override
    public void kreirajKontroler() {
        ss.kon= new JednostavanKontroler(ss.i,ss.ip);
    }

    @Override
    public void kreirajSoftverskiSistem() {
    ss = new SoftverskiSistem();
    }

    @Override
    public void prikaziEkranskuFormu() {
        ss.i.prikaziEkranskuFormu(unos, ss.ip, ss.kon);
    }

    @Override
    public void kreirajIzvestaj() {
Detaljnost d = new JednostavanPrikaz(); 
        ss.i = new IzvestajOVozilima(d);
    }

    @Override
    public void kreirajIzvorPodataka() {
    ss.ip= new IzvorPodatakaOVozilima1();     }
        
       
}

