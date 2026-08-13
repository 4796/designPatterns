package AbstractFactory;

import Abstraction.IzvorPodataka;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import java.util.Scanner;


public abstract class Projektant { // AbstractFactory
      class SoftverskiSistem
           {  Izvestaj i;
              IzvorPodataka ip;
              Kontroler kon;
           }

       SoftverskiSistem ss;
       protected Scanner unos;

       public Projektant(Scanner unos) { this.unos = unos; }

       abstract public void kreirajIzvestaj();
       abstract public void kreirajIzvorPodataka ();
       abstract public void kreirajKontroler ();
       abstract public void kreirajSoftverskiSistem();
       abstract public void prikaziEkranskuFormu();
}
