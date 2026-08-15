package Client;

import AbstractFactory.ProjektantJednostavnogIzvestajaOVozilima;
import AbstractFactory.ProjektantDetaljnogIzvestajaOVozilima;
import AbstractFactory.ProjektantDetaljnogIzvestajaOMrezi;
import AbstractFactory.ProjektantJednostavnogIzvestajaOMrezi;
import AbstractFactory.Projektant;
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
        System.out.println("=== Simulacija saobracajnih tokova ===");
        System.out.println("Izaberite detaljnost izvestaja:");
        System.out.println("1) Jednostavan");
        System.out.println("2) Detaljan");
        System.out.print("Izbor: ");
        String detaljnost = unos.nextLine().trim();

        System.out.println("Izaberite fokus izvestaja:");
        System.out.println("1) Semafori (mreza)");
        System.out.println("2) Vozila");
        System.out.print("Izbor: ");
        String fokus = unos.nextLine().trim();

        Projektant proj = odaberiProjektanta(detaljnost, fokus);
        if (proj == null) {
            System.out.println("Nepoznata kombinacija, pokusajte ponovo.");
            continue;
        }

        KorisnikSistema sef = new KorisnikSistema(proj);
        sef.kreiraj(unos);

        System.out.println();
        System.out.print("Nova simulacija? (d/n): ");
        String nastavak = unos.nextLine().trim();
        krajPrograma = !nastavak.equalsIgnoreCase("d");
    }
}

private static Projektant odaberiProjektanta(String detaljnost, String fokus) {
    if (detaljnost.equals("1") && fokus.equals("1")) {
        return new ProjektantJednostavnogIzvestajaOMrezi();
    }
    if (detaljnost.equals("1") && fokus.equals("2")) {
        return new ProjektantJednostavnogIzvestajaOVozilima();
    }
    if (detaljnost.equals("2") && fokus.equals("1")) {
        return new ProjektantDetaljnogIzvestajaOMrezi();
    }
    if (detaljnost.equals("2") && fokus.equals("2")) {
        return new ProjektantDetaljnogIzvestajaOVozilima();
    }
    return null;
}

void kreiraj(Scanner unos)     {
      Izvestaj i = proj.kreirajIzvestaj();
      IzvorPodataka ip = proj.kreirajIzvorPodataka();
      Kontroler kon = proj.kreirajKontroler(i, ip);
      ss = new SoftverskiSistem(i, ip, kon);
      ss.prikaziEkranskuFormu(unos);
}

}
