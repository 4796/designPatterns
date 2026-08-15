package AbstractProductD;

import AbstractProductA.Izvestaj;
import AbstractProductC.IzvorPodataka;
import DomainClasses.Put;
import DomainClasses.Vozilo;
import Iterator.Iterator;
import java.util.List;
import java.util.Scanner;


public abstract class Kontroler {
    Izvestaj i;
    IzvorPodataka ip;
    String poruka;
    protected int brojTrenutnogKruga = 0;
    private Iterator<Vozilo> it;

    public abstract String simulirajJedanKrug();

    protected boolean fokusSemafori() {
        return ip.fokusMreza();
    }

    public void izaberiUlicu(Scanner unos) {
        List<Put> putevi = ip.getPutevi();
        System.out.println();
        System.out.println("Izaberite ulicu za pregled vozila:");
        for (int idx = 0; idx < putevi.size(); idx++) {
            System.out.println("  " + (idx + 1) + ") " + putevi.get(idx).getNaziv());
        }
        System.out.print("Izbor: ");
        int izbor = citajBroj(unos) - 1;
        if (izbor < 0 || izbor >= putevi.size()) {
            System.out.println("Nepostojeca ulica.");
            it = null;
            return;
        }
        Put put = putevi.get(izbor);
        it = ip.getIteratorVozila(put);
        System.out.println("Pregled pokrenut za ulicu " + put.getNaziv() + ".");
    }

    public String prviAuto() { return opisi(it == null ? null : it.first()); }
    public String sledeciAuto() { return opisi(it == null ? null : it.next()); }
    public String prethodniAuto() { return opisi(it == null ? null : it.previous()); }
    public String zadnjiAuto() { return opisi(it == null ? null : it.last()); }

    private String opisi(Vozilo v) {
        if (it == null) return "Prvo izaberite ulicu (opcija 6).";
        if (v == null) return "Nema vozila na ovoj ulici.";
        return v.getId() + " - " + v.tip() + " - " + v.getMarka() + " " + v.getModel() + " (brzina " + v.getBrzina() + ")";
    }

    private int citajBroj(Scanner unos) {
        try {
            return Integer.parseInt(unos.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
