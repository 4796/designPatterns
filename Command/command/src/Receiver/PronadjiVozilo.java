package Receiver;

import AbstractProductC.IzvorPodataka;
import DomainClasses.Autobus;
import DomainClasses.Put;
import DomainClasses.Tramvaj;
import DomainClasses.Vozilo;
import java.util.Scanner;

public class PronadjiVozilo { // Receiver
    IzvorPodataka ip;
    Scanner unos;

    public PronadjiVozilo(IzvorPodataka ip1, Scanner unos1) { ip = ip1; unos = unos1; }

    public void pronadjiVozilo() {
        System.out.print("Unesite ID vozila (npr. V003): ");
        String id = unos.nextLine().trim();

        for (Put put : ip.getPutevi()) {
            for (Vozilo v : put.getVozila()) {
                if (v.getId().equalsIgnoreCase(id)) {
                    System.out.println();
                    System.out.println("Pronadjeno:");
                    System.out.println("  ID: " + v.getId());
                    System.out.println("  Tip: " + v.tip());
                    System.out.println("  Marka: " + v.getMarka());
                    System.out.println("  Model: " + v.getModel());
                    System.out.println("  Brzina: " + v.getBrzina());
                    if (v instanceof Autobus) {
                        System.out.println("  Prevoznik: " + ((Autobus) v).getPrevoznik());
                    } else if (v instanceof Tramvaj) {
                        System.out.println("  Prevoznik: " + ((Tramvaj) v).getPrevoznik());
                    }
                    System.out.println("  Ulica: " + put.getNaziv());
                    return;
                }
            }
        }
        System.out.println("Vozilo sa ID " + id + " nije pronadjeno.");
    }
}
