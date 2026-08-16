package AbstractFactory;

import AbstractClass.Kontroler;
import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodatakaOMrezi;
import AbstractProductC.IzvorPodataka;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import ConcreteClass.KompleksanKontroler;


public class ProjektantDetaljnogIzvestajaOMrezi implements Projektant {
        
    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new DetaljanPrikaz(); 
        IzvestajOMrezi i = new IzvestajOMrezi(d);
        return i;
    }   
    
    @Override
    public IzvorPodataka kreirajIzvorPodataka () 
      { IzvorPodataka ip = new IzvorPodatakaOMrezi(); 
        return ip;}  
    
    @Override
    public Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip) {
        Kontroler kon = new KompleksanKontroler(i,ip);
        return kon;
    }
        
   
}

