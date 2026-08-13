package Client;

import AbstractFactory.ProjektantJednostavnogIzvestajaOVozilima;
import AbstractFactory.ProjektantDetaljnogIzvestajaOVozilima;
import AbstractFactory.ProjektantDetaljnogIzvestajaOMrezi;
import AbstractFactory.ProjektantJednostavnogIzvestajaOMrezi;
import AbstractFactory.Projektant;
import AbstractProductA.Izvestaj;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;
import Component.Komponenta;
import Composition.CIzvestaj;
import Composition.CKontroler;
import Composition.CProjektant;
import Composition.Kompozicija;
import Leaf.CDetaljnost;
import Leaf.CIzvorPodataka;
import Leaf.List;
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
      napraviKompoziciju();
      ss.prikaziEkranskuFormu(unos);
}

void napraviKompoziciju(){
   List l1 = new CDetaljnost(ss.i.getDetaljnost());
   List l2 = new CIzvorPodataka(ss.ip);
   Kompozicija kom1 = new CIzvestaj(ss.i);
   kom1.add(l1);
   Kompozicija kom2 = new CKontroler(ss.kon);
   kom2.add(kom1);
   kom2.add(l2);
   Komponenta kom3 = new CProjektant(proj);
   kom3.add(kom1);
   kom3.add(l2);
   kom3.add(kom2);

   System.out.println();
   System.out.println("========== Struktura softverskog sistema ==========");
   System.out.println("Koren: " + nazivTipa(kom3.getTipKomponente()));
   prikaziKompoziciju(kom3, 0);
   System.out.println("========== Kraj strukture ==========");
}

void prikaziKompoziciju(Komponenta kom, int nivo)
{     nivo++;
     for(int i=0;i<kom.getBrojKomponenti();i++)
     { Komponenta km = kom.getKomponenta(i);
       StringBuilder uvod = new StringBuilder();
       for(int j=0; j<nivo; j++)
           uvod.append("   ");
       uvod.append("- ");
       System.out.println(uvod.toString() + (i+1) + ". " + nazivTipa(km.getTipKomponente()));
       prikaziKompoziciju(km, nivo);
     }
}

private static String nazivTipa(Object tip) {
    return (tip instanceof Class) ? ((Class<?>) tip).getSimpleName() : String.valueOf(tip);
}

}
