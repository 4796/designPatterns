package AbstractProductA;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;
import DomainClasses.Boja;
import DomainClasses.Put;
import DomainClasses.Vozilo;
import java.util.List;
import java.util.Scanner;



public abstract class Izvestaj {

    private static final int SIRINA_BANERA = 50;

    Detaljnost detaljnost;

    protected abstract String naslov();

    protected abstract String telo(IzvorPodataka ip);

    public String tekstIzvestaja(IzvorPodataka ip) {
        String baner = ponoviKarakter('=', SIRINA_BANERA);
        StringBuilder sb = new StringBuilder();
        sb.append(baner).append("\n");
        sb.append(centriraj(naslov(), SIRINA_BANERA)).append("\n");
        sb.append(baner).append("\n\n");
        sb.append(telo(ip));
        sb.append(baner).append("\n");
        return sb.toString();
    }

    private static String ponoviKarakter(char c, int broj) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < broj; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static String centriraj(String tekst, int sirina) {
        int razmak = Math.max(0, (sirina - tekst.length()) / 2);
        return ponoviKarakter(' ', razmak) + tekst;
    }
    
    public void prikaziEkranskuFormu(Scanner unos, IzvorPodataka ip, Kontroler kon) {
        System.out.println();
        System.out.println("Nacin upravljanja semaforima:");
        System.out.println("1) Rucno (birate raskrsnicu i boju kad god zelite)");
        System.out.println("2) Automatsko pracenje vozila (birate vozilo jednom, koridor se sam racuna svaki krug)");
        System.out.print("Izbor: ");
        boolean rucniRezim = !unos.nextLine().trim().equals("2");

        boolean kraj = false;
        while (!kraj) {
            System.out.println();
            System.out.println("--- Meni simulacije ---");
            System.out.println("1) Simuliraj sledeci krug");
            System.out.println("2) Prikazi izvestaj");
            if (rucniRezim) {
                System.out.println("3) Prinudno postavi semafor");
            } else {
                System.out.println("3) Prati vozilo");
            }
            System.out.println("0) Zavrsi ovu simulaciju");
            System.out.print("Izbor: ");
            String izbor = unos.nextLine().trim();
            switch (izbor) {
                case "1":
                    ip.pripremiSemaforeAkoPratimoVozilo();
                    System.out.println();
                    System.out.println(kon.simulirajJedanKrug());
                    break;
                case "2":
                    System.out.println();
                    System.out.println(tekstIzvestaja(ip));
                    break;
                case "3":
                    if (rucniRezim) {
                        prinudnoPostaviSemafor(unos, ip);
                    } else {
                        zapocniPracenjeVozila(unos, ip);
                    }
                    break;
                case "0":
                    kraj = true;
                    break;
                default:
                    System.out.println("Nepoznata opcija.");
            }
        }
    }

    private void prinudnoPostaviSemafor(Scanner unos, IzvorPodataka ip) {
        System.out.println();
        System.out.println("Izaberite raskrsnicu (1-" + ip.getBrojRaskrsnica() + "): ");
        System.out.print("Izbor: ");
        int indeks = citajBroj(unos) - 1;

        System.out.println("Izaberite boju: 1) Zeleno  2) Crveno");
        System.out.print("Izbor: ");
        int boja = citajBroj(unos);
        Boja zeljenaBoja = boja == 2 ? Boja.CRVENA : Boja.ZELENA;

        System.out.println();
        System.out.println(ip.prinudnoPostaviSemafor(indeks, zeljenaBoja));
    }

    private void zapocniPracenjeVozila(Scanner unos, IzvorPodataka ip) {
        List<Put> putevi = ip.getPutevi();
        System.out.println();
        System.out.println("Izaberite ulicu:");
        for (int idx = 0; idx < putevi.size(); idx++) {
            System.out.println("  " + (idx + 1) + ") " + putevi.get(idx).getNaziv());
        }
        System.out.print("Izbor: ");
        int indeksUlice = citajBroj(unos) - 1;
        if (indeksUlice < 0 || indeksUlice >= putevi.size()) {
            System.out.println("Nepostojeca ulica.");
            return;
        }

        List<Vozilo> vozila = putevi.get(indeksUlice).getVozila();
        if (vozila.isEmpty()) {
            System.out.println("Nema vozila na toj ulici.");
            return;
        }
        System.out.println("Izaberite vozilo:");
        for (int idx = 0; idx < vozila.size(); idx++) {
            System.out.println("  " + (idx + 1) + ") " + vozila.get(idx).getId() + " (brzina " + vozila.get(idx).getBrzina() + ")");
        }
        System.out.print("Izbor: ");
        int indeksVozila = citajBroj(unos) - 1;

        System.out.println();
        System.out.println(ip.zapocniPracenjeVozila(indeksUlice, indeksVozila));
    }

    private int citajBroj(Scanner unos) {
        try {
            return Integer.parseInt(unos.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
