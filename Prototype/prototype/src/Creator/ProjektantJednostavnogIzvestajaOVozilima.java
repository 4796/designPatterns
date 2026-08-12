package Creator;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodatakaOVozilima;
import AbstractProductD.JednostavanKontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;

public class ProjektantJednostavnogIzvestajaOVozilima extends Projektant {
        
    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new JednostavanPrikaz(); 
        return new IzvestajOVozilima(d);
        
    }   
    
    @Override
    public IzvorPodataka kreirajIzvorPodataka () 
      { return new IzvorPodatakaOVozilima(); 
        }  
    
    @Override
    public Kontroler kreirajKontroler (Izvestaj i, IzvorPodataka ip) {
        return new JednostavanKontroler(i,ip);
    }

}
