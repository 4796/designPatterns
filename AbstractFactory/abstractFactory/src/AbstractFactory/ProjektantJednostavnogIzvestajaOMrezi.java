package AbstractFactory;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodatakaOMrezi;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.JednostavanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;

// Promenljivo!!!
public class ProjektantJednostavnogIzvestajaOMrezi implements Projektant {
        
    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new JednostavanPrikaz(); 
        IzvestajOMrezi ip = new IzvestajOMrezi(d);
        return ip;
    } 
    
    @Override
    public IzvorPodataka kreirajIzvorPodataka () 
      { IzvorPodataka dbbr = new IzvorPodatakaOMrezi(); // Promenljivo!!!
        return dbbr;}  
    
    @Override
    public Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip) {
        Kontroler kon = new JednostavanKontroler(i,ip); // Promenljivo!!!
        return kon;
    }
        
   
}

