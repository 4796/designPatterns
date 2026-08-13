package Client;

import AbstractFactory.ProjektantJednostavnogIzvestajaOVozilima;
import AbstractFactory.ProjektantDetaljnogIzvestajaOVozilima;
import AbstractFactory.ProjektantDetaljnogIzvestajaOMrezi;
import AbstractFactory.ProjektantJednostavnogIzvestajaOMrezi;
import AbstractFactory.Projektant;
import java.util.Scanner;


public class KorisnikSistema { // Client
        Projektant proj; // AbstractFactory

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

        Projektant proj = odaberiProjektanta(detaljnost, fokus, unos);
        if (proj == null) {
            System.out.println("Nepoznata kombinacija, pokusajte ponovo.");
            continue;
        }

        KorisnikSistema sef = new KorisnikSistema(proj);
        sef.kreiraj();

        System.out.println();
        System.out.print("Nova simulacija? (d/n): ");
        String nastavak = unos.nextLine().trim();
        krajPrograma = !nastavak.equalsIgnoreCase("d");
    }
}

private static Projektant odaberiProjektanta(String detaljnost, String fokus, Scanner unos) {
    if (detaljnost.equals("1") && fokus.equals("1")) {
        return new ProjektantJednostavnogIzvestajaOMrezi(unos);
    }
    if (detaljnost.equals("1") && fokus.equals("2")) {
        return new ProjektantJednostavnogIzvestajaOVozilima(unos);
    }
    if (detaljnost.equals("2") && fokus.equals("1")) {
        return new ProjektantDetaljnogIzvestajaOMrezi(unos);
    }
    if (detaljnost.equals("2") && fokus.equals("2")) {
        return new ProjektantDetaljnogIzvestajaOVozilima(unos);
    }
    return null;
}

void kreiraj()     {
      proj.kreirajSoftverskiSistem();
      proj.kreirajIzvestaj();
      proj.kreirajIzvorPodataka();
      proj.kreirajKontroler();
      proj.prikaziEkranskuFormu();
}

}
