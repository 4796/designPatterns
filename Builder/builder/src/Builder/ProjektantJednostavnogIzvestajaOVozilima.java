package Builder;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodatakaOVozilima;
import AbstractProductD.JednostavanKontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;

public class ProjektantJednostavnogIzvestajaOVozilima extends Projektant {
        
    @Override
    public void kreirajSoftverskiSistem()
    { ss = new SoftverskiSistem();
    }
    
    @Override
    public void kreirajIzvestaj() {
        Detaljnost d = new JednostavanPrikaz(); 
        IzvestajOVozilima i = new IzvestajOVozilima(d);
        ss.i=i;
    }   
    
    @Override
    public void kreirajIzvorPodataka () 
      { ss.ip = new IzvorPodatakaOVozilima(); 
        }  
    
    @Override
    public void kreirajKontroler () {
        ss.kon = new JednostavanKontroler(ss.i,ss.ip);
    }

}
