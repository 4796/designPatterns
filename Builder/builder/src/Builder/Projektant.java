package Builder;

import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import java.util.Scanner;

public abstract class Projektant { // Builder

       class SoftverskiSistem // Product
           {  Izvestaj i; // AbstractProductA
              IzvorPodataka ip; // AbstractProductB
              Kontroler kon; // AbstractProductC

              void prikaziEkranskuFormu(Scanner unos) {
                  boolean kraj = false;
                  while (!kraj) {
                      System.out.println();
                      System.out.println("--- Meni simulacije ---");
                      System.out.println("1) Simuliraj sledeci krug");
                      System.out.println("2) Prikazi izvestaj");
                      System.out.println("0) Zavrsi ovu simulaciju");
                      System.out.print("Izbor: ");
                      String izbor = unos.nextLine().trim();
                      switch (izbor) {
                          case "1":
                              System.out.println();
                              System.out.println(kon.simulirajJedanKrug());
                              break;
                          case "2":
                              System.out.println();
                              System.out.println(i.tekstIzvestaja(ip));
                              break;
                          case "0":
                              kraj = true;
                              break;
                          default:
                              System.out.println("Nepoznata opcija.");
                      }
                  }
              }
           }


        SoftverskiSistem ss;

       abstract public void kreirajSoftverskiSistem();
       abstract public void kreirajIzvestaj();
       abstract public void kreirajIzvorPodataka ();
       abstract public void kreirajKontroler ();

       public void prikaziEkranskuFormu(Scanner unos) {
           ss.prikaziEkranskuFormu(unos);
       }

}
