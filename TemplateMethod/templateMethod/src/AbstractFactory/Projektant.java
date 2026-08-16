package AbstractFactory;

import AbstractClass.Kontroler;
import AbstractProductC.IzvorPodataka;
import AbstractProductA.*;

public interface Projektant { // Creator
       Izvestaj kreirajIzvestaj();
       IzvorPodataka kreirajIzvorPodataka ();
       Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip);

}
