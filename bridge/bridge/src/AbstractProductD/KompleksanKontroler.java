package AbstractProductD;

import Abstraction.IzvorPodataka;
import AbstractProductA.*;
import DomainClasses.Boja;
import DomainClasses.Put;
import DomainClasses.Raskrsnica;
import DomainClasses.Semafor;
import DomainClasses.Vozilo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public final class KompleksanKontroler extends Kontroler{


    public KompleksanKontroler(Izvestaj ef1,IzvorPodataka bbp1){i=ef1;ip=bbp1;  }



    @Override
    public String simulirajJedanKrug() {
        brojTrenutnogKruga++;
        List<Put> putevi = ip.getPutevi();
        boolean fokusSemafori = fokusSemafori();

        // boja svakog semafora na pocetku kruga - koristi se za SVE odluke o pomeranju
        // u ovom krugu, da bi ceo krug bio zasnovan na istom, nepromenjenom stanju
        Map<Put, Boja> bojaNaPocetku = new HashMap<>();
        List<List<Vozilo>> snapshotVozila = new ArrayList<>();
        for (Put put : putevi) {
            bojaNaPocetku.put(put, put.getSledecaRaskrsnica().getSemafor().getBoja());
            snapshotVozila.add(new ArrayList<>(put.getVozila()));
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Krug ").append(brojTrenutnogKruga).append(":\n");

        // Pomeranje: na zelenom semaforu polazi CELA ulica (isto kao kod jednostavne
        // simulacije), ali brzo vozilo moze u istom krugu da nastavi kroz jos zelenih
        // semafora ispred sebe - staje na prvom crvenom ili kad potrosi svoju brzinu.
        for (int idx = 0; idx < putevi.size(); idx++) {
            Put polaznaUlica = putevi.get(idx);
            List<Vozilo> vozilaNaPocetku = snapshotVozila.get(idx);

            for (Vozilo v : vozilaNaPocetku) {
                Put trenutna = polaznaUlica;
                int preostaliHopovi = v.getBrzina();
                while (preostaliHopovi > 0 && bojaNaPocetku.get(trenutna) == Boja.ZELENA) {
                    trenutna = trenutna.getSledecaRaskrsnica().getNaredniPut();
                    preostaliHopovi--;
                }
                if (trenutna != polaznaUlica) {
                    polaznaUlica.getVozila().remove(v);
                    trenutna.dodajVozilo(v);
                }
            }

            if (!fokusSemafori) {
                if (bojaNaPocetku.get(polaznaUlica) == Boja.ZELENA) {
                    sb.append("  ").append(polaznaUlica.getNaziv()).append(" -> ")
                      .append(polaznaUlica.getSledecaRaskrsnica().getNaredniPut().getNaziv())
                      .append(": ").append(vozilaNaPocetku.size()).append(" vozila preslo\n");
                } else {
                    sb.append("  ").append(polaznaUlica.getNaziv())
                      .append(": prolaz zatvoren, ").append(vozilaNaPocetku.size()).append(" vozila ceka\n");
                }
            }
        }

        // Promena boje semafora - tek kad brojac krugova u trenutnom stanju dostigne trajanje.
        for (Semafor semafor : ip.getSemafori()) {
            Boja pre = semafor.getBoja();
            if (semafor.predvidjaSePromenaSledeceRunde()) {
                semafor.promeniBoju();
            } else {
                semafor.produziTrenutnoStanje();
            }
            if (fokusSemafori) {
                Raskrsnica r = pronadjiRaskrsnicu(putevi, semafor);
                if (pre != semafor.getBoja()) {
                    sb.append("  ").append(r.getOznaka()).append(": ")
                      .append(pre.prikaz()).append(" -> ").append(semafor.getBoja().prikaz()).append("\n");
                } else {
                    sb.append("  ").append(r.getOznaka()).append(": ").append(semafor.getBoja().prikaz()).append("\n");
                }
            }
        }

        return sb.toString();
    }

    private Raskrsnica pronadjiRaskrsnicu(List<Put> putevi, Semafor semafor) {
        for (Put put : putevi) {
            if (put.getSledecaRaskrsnica().getSemafor() == semafor) {
                return put.getSledecaRaskrsnica();
            }
        }
        return null;
    }

}

