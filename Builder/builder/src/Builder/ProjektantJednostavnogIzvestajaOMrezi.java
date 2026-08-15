package Builder;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodatakaOMrezi;
import AbstractProductD.JednostavanKontroler;
import AbstractProductA.*;
import AbstractProductB.JednostavanPrikaz;

public class ProjektantJednostavnogIzvestajaOMrezi extends Projektant {
        
    @Override
    public void kreirajSoftverskiSistem()
    { ss = new SoftverskiSistem();
    }
    
    @Override
    public void kreirajIzvestaj() {
        Detaljnost d = new JednostavanPrikaz(); 
        IzvestajOMrezi i = new IzvestajOMrezi(d);
        ss.i=i;
    }   
    
    @Override
    public void kreirajIzvorPodataka () 
      { ss.ip = new IzvorPodatakaOMrezi(); 
        }  
    
    @Override
    public void kreirajKontroler () {
        ss.kon = new JednostavanKontroler(ss.i,ss.ip);
    }

}