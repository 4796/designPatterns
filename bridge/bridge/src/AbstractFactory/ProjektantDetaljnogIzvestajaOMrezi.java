package AbstractFactory;

import AbstractProductB.Detaljnost;
import RefinedAbstraction.IzvorPodatakaOMrezi1;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import AbstractProductD.KompleksanKontroler;
import java.util.Scanner;


public class ProjektantDetaljnogIzvestajaOMrezi extends Projektant {

    public ProjektantDetaljnogIzvestajaOMrezi(Scanner unos) { super(unos); }

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
        ss.i = new IzvestajOMrezi(d);
    }

    @Override
    public void kreirajIzvorPodataka() {
    ss.ip= new IzvorPodatakaOMrezi1();     }
        
   
}

