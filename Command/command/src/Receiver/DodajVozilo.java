package Receiver;

import AbstractProductC.IzvorPodataka;
import DomainClasses.Auto;
import DomainClasses.Autobus;
import DomainClasses.Put;
import DomainClasses.Tramvaj;
import DomainClasses.Vozilo;
import java.util.List;
import java.util.Scanner;

public class DodajVozilo { // Receiver
    IzvorPodataka ip;
    Scanner unos;

    public DodajVozilo(IzvorPodataka ip1, Scanner unos1) { ip = ip1; unos = unos1; }

    public void dodajVozilo() {
        List<Put> putevi = ip.getPutevi();
        System.out.println();
        System.out.println("Izaberite ulicu:");
        for (int idx = 0; idx < putevi.size(); idx++) {
            System.out.println("  " + (idx + 1) + ") " + putevi.get(idx).getNaziv());
        }
        System.out.print("Izbor: ");
        int izborUlice = citajBroj() - 1;
        if (izborUlice < 0 || izborUlice >= putevi.size()) {
            System.out.println("Nepostojeca ulica.");
            return;
        }
        Put put = putevi.get(izborUlice);

        System.out.println("Tip vozila: 1) Automobil  2) Autobus  3) Tramvaj");
        System.out.print("Izbor: ");
        int tip = citajBroj();

        System.out.print("Marka: ");
        String marka = unos.nextLine().trim();
        System.out.print("Model: ");
        String model = unos.nextLine().trim();
        System.out.print("Brzina: ");
        int brzina = citajBroj();

        Vozilo v;
        if (tip == 2) {
            System.out.print("Prevoznik: ");
            String prevoznik = unos.nextLine().trim();
            v = new Autobus(marka, model, brzina, prevoznik);
        } else if (tip == 3) {
            System.out.print("Prevoznik: ");
            String prevoznik = unos.nextLine().trim();
            v = new Tramvaj(marka, model, brzina, prevoznik);
        } else {
            v = new Auto(marka, model, brzina);
        }

        put.dodajVozilo(v);
        System.out.println("Dodato vozilo " + v.getId() + " (" + v.tip() + ") na ulicu " + put.getNaziv() + ".");
    }

    private int citajBroj() {
        try {
            return Integer.parseInt(unos.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
