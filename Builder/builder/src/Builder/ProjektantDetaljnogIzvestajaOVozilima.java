package Builder;

import AbstractProductB.Detaljnost;
import AbstractProductD.KompleksanKontroler;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import AbstractProductC.IzvorPodatakaOVozilima;

public class ProjektantDetaljnogIzvestajaOVozilima extends Projektant {
        
    @Override
    public void kreirajSoftverskiSistem()
    { ss = new SoftverskiSistem();
    }
    
    @Override
    public void kreirajIzvestaj() {
        Detaljnost d = new DetaljanPrikaz(); 
        IzvestajOVozilima i = new IzvestajOVozilima(d);
        ss.i=i;
    }   
    
    @Override
    public void kreirajIzvorPodataka () 
      { ss.ip = new IzvorPodatakaOVozilima(); 
        }  
    
    @Override
    public void kreirajKontroler () {
        ss.kon = new KompleksanKontroler(ss.i,ss.ip);
    }

}

