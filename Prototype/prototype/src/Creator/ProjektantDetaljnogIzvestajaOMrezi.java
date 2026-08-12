package Creator;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodatakaOMrezi;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.KompleksanKontroler;
import AbstractProductD.Kontroler;


public class ProjektantDetaljnogIzvestajaOMrezi extends Projektant {
        

    
    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new DetaljanPrikaz(); 
        return new IzvestajOMrezi(d);
        
    }   
    
    @Override
    public IzvorPodataka kreirajIzvorPodataka () 
      { return new IzvorPodatakaOMrezi(); 
        }  
    
    @Override
    public Kontroler kreirajKontroler (Izvestaj i, IzvorPodataka ip) {
        return new KompleksanKontroler(i,ip);
    }

    

}

