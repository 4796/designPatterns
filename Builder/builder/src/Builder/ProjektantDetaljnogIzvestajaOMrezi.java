package Builder;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodatakaOMrezi;
import AbstractProductA.*;
import AbstractProductB.DetaljanPrikaz;
import AbstractProductD.KompleksanKontroler;


public class ProjektantDetaljnogIzvestajaOMrezi extends Projektant {
        
    @Override
    public void kreirajSoftverskiSistem()
    { ss = new SoftverskiSistem();
    }
    
    @Override
    public void kreirajIzvestaj() {
        Detaljnost d = new DetaljanPrikaz(); 
        IzvestajOMrezi i = new IzvestajOMrezi(d);
        ss.i=i;
    }   
    
    @Override
    public void kreirajIzvorPodataka () 
      { ss.ip = new IzvorPodatakaOMrezi(); 
        }  
    
    @Override
    public void kreirajKontroler () {
        ss.kon = new KompleksanKontroler(ss.i,ss.ip);
    }

}

