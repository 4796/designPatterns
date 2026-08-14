package AbstractFactory;

import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import java.util.Scanner;

public interface Projektant {
       Izvestaj kreirajIzvestaj();
       IzvorPodataka kreirajIzvorPodataka ();
       Kontroler kreirajKontroler (Izvestaj i,IzvorPodataka ip);
       void povezi(IzvorPodataka ip, Scanner unos);
}
