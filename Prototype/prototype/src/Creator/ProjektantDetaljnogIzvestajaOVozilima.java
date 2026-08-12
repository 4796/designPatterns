package Creator;

import AbstractProductB.Detaljnost;
import AbstractProductD.KompleksanKontroler;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import AbstractProductC.IzvorPodataka;
import AbstractProductC.IzvorPodatakaOVozilima;
import AbstractProductD.Kontroler;

public class ProjektantDetaljnogIzvestajaOVozilima extends Projektant {
        
    @Override
    public Izvestaj kreirajIzvestaj() {
        Detaljnost d = new DetaljanPrikaz(); 
        return new IzvestajOVozilima(d);
        
    }   
    
    @Override
    public IzvorPodataka kreirajIzvorPodataka () 
      { return new IzvorPodatakaOVozilima(); 
        }  
    
    @Override
    public Kontroler kreirajKontroler (Izvestaj i, IzvorPodataka ip) {
        return new KompleksanKontroler(i,ip);
    }

}

