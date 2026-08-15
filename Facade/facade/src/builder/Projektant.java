package builder;

import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;
import AbstractProductA.*;
import java.util.Scanner;

public abstract class Projektant {
       abstract public void kreirajIzvestaj();   
       abstract public void kreirajIzvorPodataka ();
       abstract public void kreirajKontroler ();
       public void kreirajSoftverskiSistem(){
           ss=new SoftverskiSistem();
       }
       public void prikaziEkranskuFormu(){
       ss.prikaziMeniUKonzoli();
       }
       
                    
                    

       
       class SoftverskiSistem //  
           {  Izvestaj i; //  
              IzvorPodataka ip; //  
              Kontroler kon; //  

              public void prikaziMeniUKonzoli() {
                Scanner unos = new Scanner(System.in);
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
                            System.out.println(ss.kon.simulirajJedanKrug());
                            break;
                        case "2":
                            System.out.println();
                            System.out.println(ss.i.tekstIzvestaja(ss.ip));
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

}