package AbstractFactory;

import AbstractProductC.IzvorPodataka;
import Subject.Kontroler;
import AbstractProductA.*;

public interface Projektant {
       Izvestaj kreirajIzvestaj();
       IzvorPodataka kreirajIzvorPodataka ();
       Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip);
}
