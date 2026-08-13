package Adaptee;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.KompleksanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import AbstractProductC.IzvorPodatakaOVozilima;
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
    ss.ip= new IzvorPodatakaOVozilima();     }
        
        
   
}

