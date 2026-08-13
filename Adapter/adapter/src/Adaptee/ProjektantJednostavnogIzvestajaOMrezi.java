package Adaptee;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodatakaOMrezi;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.JednostavanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;
import java.util.Scanner;

public class ProjektantJednostavnogIzvestajaOMrezi extends Projektant {

    public ProjektantJednostavnogIzvestajaOMrezi(Scanner unos) { super(unos); }

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
        ss.i = new IzvestajOMrezi(d);
    }

    @Override
    public void kreirajIzvorPodataka() {
    ss.ip= new IzvorPodatakaOMrezi();     }
        
       
        
   
}

