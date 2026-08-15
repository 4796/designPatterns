package Receiver;

import AbstractProductC.IzvorPodataka;
import DomainClasses.Put;
import DomainClasses.Vozilo;
import java.util.Scanner;

public class UkloniVozilo { // Receiver
    IzvorPodataka ip;
    Scanner unos;

    public UkloniVozilo(IzvorPodataka ip1, Scanner unos1) { ip = ip1; unos = unos1; }

    public void ukloniVozilo() {
        System.out.print("Unesite ID vozila (npr. V003): ");
        String id = unos.nextLine().trim();

        for (Put put : ip.getPutevi()) {
            Vozilo pronadjeno = null;
            for (Vozilo v : put.getVozila()) {
                if (v.getId().equalsIgnoreCase(id)) {
                    pronadjeno = v;
                    break;
                }
            }
            if (pronadjeno != null) {
                put.getVozila().remove(pronadjeno);
                System.out.println("Uklonjeno vozilo " + pronadjeno.getId() + " sa ulice " + put.getNaziv() + ".");
                return;
            }
        }
        System.out.println("Vozilo sa ID " + id + " nije pronadjeno.");
    }
}
