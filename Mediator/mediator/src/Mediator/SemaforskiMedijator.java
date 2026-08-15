package Mediator;

import Colleaque.Colleague;
import Colleaque.RaskrsnicaKolega;
import Colleaque.VoziloKolega;
import DomainClasses.Boja;
import DomainClasses.Raskrsnica;
import DomainClasses.Vozilo;
import java.util.List;

public class SemaforskiMedijator implements Mediator { // ConcreteMediator

    private final RaskrsnicaKolega k1;
    private final RaskrsnicaKolega k2;
    private final RaskrsnicaKolega k3;
    private final RaskrsnicaKolega k4;
    private VoziloKolega praceno;

    public SemaforskiMedijator(List<Raskrsnica> raskrsnice) {
        k1 = new RaskrsnicaKolega(raskrsnice.get(0));
        k2 = new RaskrsnicaKolega(raskrsnice.get(1));
        k3 = new RaskrsnicaKolega(raskrsnice.get(2));
        k4 = new RaskrsnicaKolega(raskrsnice.get(3));
        for (RaskrsnicaKolega k : sveKolege()) {
            k.setMediator(this);
        }
    }

    @Override
    public void zatraziPromenu(Colleague posiljalac, Boja zeljenaBoja) {
        for (RaskrsnicaKolega k : sveKolege()) {
            if (k == posiljalac) {
                k.postaviBoju(zeljenaBoja);
            } else {
                k.postaviBoju(Boja.CRVENA);
            }
        }
    }

    @Override
    public void zatraziKoridor(Raskrsnica pocetna, int duzina) {
        RaskrsnicaKolega[] sve = sveKolege();
        for (RaskrsnicaKolega k : sve) {
            k.postaviBoju(Boja.CRVENA);
        }
        RaskrsnicaKolega trenutna = kolegaZa(pocetna, sve);
        int koraka = Math.min(duzina, sve.length);
        for (int i = 0; i < koraka && trenutna != null; i++) {
            trenutna.postaviBoju(Boja.ZELENA);
            Raskrsnica sledeca = trenutna.getRaskrsnica().getNaredniPut().getSledecaRaskrsnica();
            trenutna = kolegaZa(sledeca, sve);
        }
    }

    @Override
    public int brojKolega() {
        return sveKolege().length;
    }

    @Override
    public String prinudnoPostaviSemafor(int indeks, Boja zeljenaBoja) {
        RaskrsnicaKolega[] sve = sveKolege();
        if (indeks < 0 || indeks >= sve.length) {
            return "Nepostojeca raskrsnica.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Pre:\n");
        for (RaskrsnicaKolega k : sve) {
            dodajOpis(sb, k);
        }
        sve[indeks].zatraziPromenu(zeljenaBoja);
        sb.append("Posle:\n");
        for (RaskrsnicaKolega k : sve) {
            dodajOpis(sb, k);
        }
        return sb.toString();
    }

    @Override
    public void pratiVozilo(Vozilo vozilo) {
        praceno = new VoziloKolega(vozilo);
        praceno.setMediator(this);
    }

    @Override
    public void pripremiSemaforeAkoPratimoVozilo() {
        if (praceno != null) {
            praceno.pripremiKrug();
        }
    }

    private void dodajOpis(StringBuilder sb, RaskrsnicaKolega k) {
        sb.append("  ").append(k.getRaskrsnica().getOznaka()).append(": ")
          .append(k.getRaskrsnica().getSemafor().getBoja().prikaz()).append("\n");
    }

    private RaskrsnicaKolega[] sveKolege() {
        return new RaskrsnicaKolega[]{k1, k2, k3, k4};
    }

    private RaskrsnicaKolega kolegaZa(Raskrsnica r, RaskrsnicaKolega[] sve) {
        for (RaskrsnicaKolega k : sve) {
            if (k.getRaskrsnica() == r) {
                return k;
            }
        }
        return null;
    }

}
