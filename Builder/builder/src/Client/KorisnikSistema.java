package Client;

import Builder.*;
import java.util.Scanner;

public class KorisnikSistema { // Client / Direktor
        Projektant proj; // Builder

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

void kreiraj(Scanner unos) {
      proj.kreirajSoftverskiSistem();
      proj.kreirajIzvestaj();
      proj.kreirajIzvorPodataka();
      proj.kreirajKontroler();
      proj.prikaziEkranskuFormu(unos);
}

}
