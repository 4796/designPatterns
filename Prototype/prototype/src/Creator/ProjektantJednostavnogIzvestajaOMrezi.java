package Creator;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodatakaOMrezi;
import AbstractProductD.JednostavanKontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;

public class ProjektantJednostavnogIzvestajaOMrezi extends Projektant {
        
    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new JednostavanPrikaz(); 
        return new IzvestajOMrezi(d);
        
    }   
    
    @Override
    public IzvorPodataka kreirajIzvorPodataka () 
      { return new IzvorPodatakaOMrezi(); 
        }  
    
    @Override
    public Kontroler kreirajKontroler (Izvestaj i, IzvorPodataka ip) {
        return new JednostavanKontroler(i,ip);
    }

}