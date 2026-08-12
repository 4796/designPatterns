package Creator;

import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import Product.SoftverskiSistem;
import Product.SoftverskiSistem1;
import java.util.Scanner;

public abstract class Projektant { // Creator
       SoftverskiSistem ss;
       abstract Izvestaj kreirajIzvestaj();
       abstract IzvorPodataka kreirajIzvorPodataka ();
       abstract Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip);

       public void kreiraj(Scanner unos)
        { Izvestaj i =kreirajIzvestaj();
          IzvorPodataka ip = kreirajIzvorPodataka();
          Kontroler kon= kreirajKontroler(i,ip);
          ss = new SoftverskiSistem1(i,ip,kon);
          ss.prikaziEkranskuFormu(unos);
        }
}
