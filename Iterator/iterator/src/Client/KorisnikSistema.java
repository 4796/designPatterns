package Client;

import AbstractFactory.Projektant;
import AbstractFactory.ProjektantDetaljnogIzvestajaOVozilima;
import AbstractProductA.Izvestaj;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;
import java.util.Scanner;


public class KorisnikSistema { // Client
        Projektant proj; // Abstract Factory

        class SoftverskiSistem // Complex Product
           {  Izvestaj i; // AbstractProductA
              IzvorPodataka ip; // AbstractProductC
              Kontroler kon; // AbstractProductD

              SoftverskiSistem(Izvestaj i1,IzvorPodataka ip1,Kontroler kon1){i=i1;ip=ip1;kon=kon1;}
              void prikaziEkranskuFormu(Scanner unos){i.prikaziEkranskuFormu(unos, ip, kon);}
           }
        SoftverskiSistem ss;

    KorisnikSistema (Projektant proj1){proj = proj1; }


public static void main(String args[])  {
    Scanner unos = new Scanner(System.in);
    boolean krajPrograma = false;

    while (!krajPrograma) {
        System.out.println();
        System.out.println("=== Simulacija saobracajnih tokova (detaljan izvestaj o vozilima) ===");

        Projektant proj = new ProjektantDetaljnogIzvestajaOVozilima();
        KorisnikSistema sef = new KorisnikSistema(proj);
        sef.kreiraj(unos);

        System.out.println();
        System.out.print("Nova simulacija? (d/n): ");
        String nastavak = unos.nextLine().trim();
        krajPrograma = !nastavak.equalsIgnoreCase("d");
    }
}

void kreiraj(Scanner unos)     {
      Izvestaj i = proj.kreirajIzvestaj();
      IzvorPodataka ip = proj.kreirajIzvorPodataka();
      Kontroler kon = proj.kreirajKontroler(i, ip);
      ss = new SoftverskiSistem(i, ip, kon);
      ss.prikaziEkranskuFormu(unos);
}

}
