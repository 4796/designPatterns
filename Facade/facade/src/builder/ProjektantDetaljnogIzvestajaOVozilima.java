
package builder;

import AbstractProductB.Detaljnost;
import AbstractProductD.KompleksanKontroler;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import AbstractProductC.IzvorPodatakaOVozilima;

// Promenljivo!!!
public class ProjektantDetaljnogIzvestajaOVozilima extends Projektant {
        
    @Override
    public void kreirajIzvestaj() {
        Detaljnost d = new DetaljanPrikaz(); 
        ss.i = new IzvestajOVozilima(d);
    }   
    
    @Override
    public void kreirajIzvorPodataka () 
      { ss.ip = new IzvorPodatakaOVozilima(); // Promenljivo!!!
        }  
    
    @Override
    public void kreirajKontroler () {
        ss.kon = new KompleksanKontroler(ss.i,ss.ip); // Promenljivo!!!
    }
        
   
}

