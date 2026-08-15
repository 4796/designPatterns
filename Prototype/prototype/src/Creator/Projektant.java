package Creator;

import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import Product.SoftverskiSistem;
import Product.SoftverskiSistem1;
import java.util.Scanner;

public abstract class Projektant { // Builder


        



        SoftverskiSistem ss;

       
       abstract public Izvestaj kreirajIzvestaj();
       abstract public IzvorPodataka kreirajIzvorPodataka ();
       abstract public Kontroler kreirajKontroler (Izvestaj i, IzvorPodataka ip);

       public void kreiraj(Scanner unos){
          Izvestaj i =kreirajIzvestaj();
          IzvorPodataka bbp = kreirajIzvorPodataka();
          Kontroler kon= kreirajKontroler(i,bbp);
          ss = new SoftverskiSistem1(i,bbp,kon);
          ss.prikaziEkranskuFormu(unos);
          try { Thread.sleep(3000);} catch (InterruptedException ex) {}
          ss.zatvoriEkranskuFormu();
          System.out.println("Kreiram novi prototip.");
          try { Thread.sleep(3000);} catch (InterruptedException ex) {}
          SoftverskiSistem ss1 = ss.Clone();
          ss1.prikaziEkranskuFormu(unos);
       }
       
       
       

}
