package builder;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;
import AbstractProductC.IzvorPodatakaOVozilima;
import AbstractProductD.JednostavanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;

// Promenljivo!!!
public class ProjektantJednostavnogIzvestajaOVozilima extends Projektant {
        
    @Override
    public void kreirajIzvestaj() {
        Detaljnost d = new JednostavanPrikaz(); 
        ss.i = new IzvestajOVozilima(d);
    }   
    
    @Override
    public void kreirajIzvorPodataka () 
      { ss.ip = new IzvorPodatakaOVozilima(); // Promenljivo!!!
        }  
    
    @Override
    public void kreirajKontroler () {
        ss.kon = new JednostavanKontroler(ss.i,ss.ip); // Promenljivo!!!

    }
        
   
}

