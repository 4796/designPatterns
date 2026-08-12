package AbstractFactory;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;
import AbstractProductC.IzvorPodatakaOVozilima;
import AbstractProductD.JednostavanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;

// Promenljivo!!!
public class ProjektantJednostavnogIzvestajaOVozilima implements Projektant {
        
    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new JednostavanPrikaz(); 
        IzvestajOVozilima ip = new IzvestajOVozilima(d);
        return ip;
    }   
    
    @Override
    public IzvorPodataka kreirajIzvorPodataka () 
      { IzvorPodataka dbbr = new IzvorPodatakaOVozilima(); // Promenljivo!!!
        return dbbr;}  
    
    @Override
    public Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip) {
        Kontroler kon = new JednostavanKontroler(i,ip); // Promenljivo!!!
        return kon;
    }
        
   
}

