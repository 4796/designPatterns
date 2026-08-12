package Product;

import AbstractProductA.Izvestaj;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;
import java.util.Scanner;



public class SoftverskiSistem1 implements SoftverskiSistem// ConcretePrototype
           {  Izvestaj i; // AbstractProductA
              IzvorPodataka ip; // AbstractProductB
              Kontroler kon; // AbstractProductC
              public SoftverskiSistem1(Izvestaj i1,IzvorPodataka ip1,Kontroler kon1){i=i1;ip=ip1;kon=kon1;}
              public SoftverskiSistem1(SoftverskiSistem1 ss1){i=ss1.i;ip=ss1.ip;kon=ss1.kon;}
              @Override
              public void prikaziEkranskuFormu(Scanner unos) {
                  i.prikaziEkranskuFormu(unos, ip, kon);
                }
              @Override
              public void zatvoriEkranskuFormu(){
                  i.zatvoriEkranskuFormu();
                }
              public SoftverskiSistem Clone() { return new SoftverskiSistem1(this);}
           }
