package AbstractProductA;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;



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

    public void prikaziMeniUKonzoli() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
