package Client;

import Adaptee.ProjektantJednostavnogIzvestajaOVozilima;
import Adaptee.ProjektantDetaljnogIzvestajaOVozilima;
import Adaptee.ProjektantDetaljnogIzvestajaOMrezi;
import Adaptee.ProjektantJednostavnogIzvestajaOMrezi;
import Adapter.Prevodilac1;
import Target.Prevodilac;
import java.util.Scanner;


public class KorisnikSistema { // Client
        Prevodilac proj; // Target

    KorisnikSistema (Prevodilac proj1){proj = proj1; }

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

        Prevodilac proj = odaberiPrevodioca(detaljnost, fokus, unos);
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

private static Prevodilac odaberiPrevodioca(String detaljnost, String fokus, Scanner unos) {
    if (detaljnost.equals("1") && fokus.equals("1")) {
        return new Prevodilac1(new ProjektantJednostavnogIzvestajaOMrezi(unos));
    }
    if (detaljnost.equals("1") && fokus.equals("2")) {
        return new Prevodilac1(new ProjektantJednostavnogIzvestajaOVozilima(unos));
    }
    if (detaljnost.equals("2") && fokus.equals("1")) {
        return new Prevodilac1(new ProjektantDetaljnogIzvestajaOMrezi(unos));
    }
    if (detaljnost.equals("2") && fokus.equals("2")) {
        return new Prevodilac1(new ProjektantDetaljnogIzvestajaOVozilima(unos));
    }
    return null;
}

void kreiraj()     {
      proj.kreirajSistem();
      proj.kreirajIzvestaj();
      proj.kreirajIzvorPodataka();
      proj.kreirajKontroler();
      proj.prikaziEkranskuFormu();
}

}
