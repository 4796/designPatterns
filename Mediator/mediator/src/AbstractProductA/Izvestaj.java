package AbstractProductA;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;
import AbstractProductD.Kontroler;
import DomainClasses.Boja;
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
        boolean kraj = false;
        while (!kraj) {
            System.out.println();
            System.out.println("--- Meni simulacije ---");
            System.out.println("1) Simuliraj sledeci krug");
            System.out.println("2) Prikazi izvestaj");
            System.out.println("3) Prinudno postavi semafor");
            System.out.println("0) Zavrsi ovu simulaciju");
            System.out.print("Izbor: ");
            String izbor = unos.nextLine().trim();
            switch (izbor) {
                case "1":
                    System.out.println();
                    System.out.println(kon.simulirajJedanKrug());
                    break;
                case "2":
                    System.out.println();
                    System.out.println(tekstIzvestaja(ip));
                    break;
                case "3":
                    prinudnoPostaviSemafor(unos, ip);
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

    private int citajBroj(Scanner unos) {
        try {
            return Integer.parseInt(unos.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
