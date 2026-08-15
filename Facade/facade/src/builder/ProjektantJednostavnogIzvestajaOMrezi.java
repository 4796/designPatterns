package builder;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodatakaOMrezi;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.JednostavanKontroler;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;

// Promenljivo!!!
public class ProjektantJednostavnogIzvestajaOMrezi extends Projektant {
        
    @Override
    public void kreirajIzvestaj() {
        Detaljnost d = new JednostavanPrikaz(); 
        ss.i = new IzvestajOMrezi(d);
    } 
    
    @Override
    public void kreirajIzvorPodataka () 
      { ss.ip = new IzvorPodatakaOMrezi(); // Promenljivo!!!
        }  
    
    @Override
    public void kreirajKontroler () {
        ss.kon = new JednostavanKontroler(ss.i,ss.ip); // Promenljivo!!!
    }
        
   
}

