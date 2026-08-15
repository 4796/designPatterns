package Product;

import AbstractProductA.Izvestaj;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;
import java.util.Scanner;




public class SoftverskiSistem1 implements SoftverskiSistem// Concrete Product
           {  Izvestaj i; // AbstractProductA
              IzvorPodataka ip; // AbstractProductB
              Kontroler kon; // AbstractProductC
              public SoftverskiSistem1(Izvestaj i1,IzvorPodataka ip1,Kontroler kon1){i=i1;ip=ip1;kon=kon1;}
              @Override
              public void prikaziEkranskuFormu(Scanner unos) {
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
