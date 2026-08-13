package AbstractFactory;

import AbstractProductB.Detaljnost;
import AbstractProductD.KompleksanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import RefinedAbstraction.IzvorPodatakaOVozilima1;
import java.util.Scanner;

public class ProjektantDetaljnogIzvestajaOVozilima extends Projektant {

    public ProjektantDetaljnogIzvestajaOVozilima(Scanner unos) { super(unos); }

     @Override
    public void kreirajKontroler() {
        ss.kon= new KompleksanKontroler(ss.i,ss.ip);
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
Detaljnost d = new DetaljanPrikaz(); 
        ss.i = new IzvestajOVozilima(d);
    }

    @Override
    public void kreirajIzvorPodataka() {
    ss.ip= new IzvorPodatakaOVozilima1();     }
        
        
   
}

