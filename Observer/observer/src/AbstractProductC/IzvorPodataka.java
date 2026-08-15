package AbstractProductC;

import DomainClasses.Auto;
import DomainClasses.Autobus;
import DomainClasses.Boja;
import DomainClasses.Put;
import DomainClasses.Raskrsnica;
import DomainClasses.SaobracajnaMreza;
import DomainClasses.Semafor;
import DomainClasses.Tramvaj;
import DomainClasses.Vozilo;
import Observer.SemaforObserver;
import Observer.Subject;
import Observer.VoziloObserver;
import Observer.ZagusenjeIspisObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public abstract class IzvorPodataka extends Subject // ConcreteSubject
{
    private static final int BROJ_ULICA = 4;
    private static final Random RANDOM = new Random();
    public static final int PRAG_ZAGUSENJA = 6;

    SaobracajnaMreza saobracajnaMreza;


    public abstract boolean fokusMreza();

    public boolean jeZagusena(Put put) {
        return put.getVozila().size() >= PRAG_ZAGUSENJA;
    }

    private void povezaniObserveri(List<Put> putevi, List<Semafor> semafori) {
        attach(new SemaforObserver(this, semafori));
        attach(new VoziloObserver(this, putevi));
        attach(new ZagusenjeIspisObserver(this));
    }


    public List<Put> getPutevi() {
        return saobracajnaMreza.getPutevi();
    }


    public List<Semafor> getSemafori() {
        return saobracajnaMreza.getSemafori();
    }

    protected SaobracajnaMreza izgradiMrezu() {
        List<Put> putevi = new ArrayList<>();
        List<Raskrsnica> raskrsnice = new ArrayList<>();
        List<Semafor> semafori = new ArrayList<>();

        for (int i = 1; i <= BROJ_ULICA; i++) {
            Put put = new Put("Ulica " + i);
            Semafor semafor = new Semafor(nasumicnaBoja(), 2 + RANDOM.nextInt(3));
            Raskrsnica raskrsnica = new Raskrsnica("R" + i, semafor);
            put.setSledecaRaskrsnica(raskrsnica);

            putevi.add(put);
            raskrsnice.add(raskrsnica);
            semafori.add(semafor);
        }

        for (int i = 0; i < BROJ_ULICA; i++) {
            Put naredni = putevi.get((i + 1) % BROJ_ULICA);
            raskrsnice.get(i).setNaredniPut(naredni);
        }

        // Prva ulica namerno dobija dovoljno vozila da odmah bude zagusena, da bi
        // se Observer efekat mogao demonstrirati bez oslanjanja na slucajnost.
        boolean prva = true;
        for (Put put : putevi) {
            int brojVozila = prva ? PRAG_ZAGUSENJA + 2 : 1 + RANDOM.nextInt(6);
            prva = false;
            for (int j = 0; j < brojVozila; j++) {
                put.dodajVozilo(nasumicnoVozilo());
            }
        }

        povezaniObserveri(putevi, semafori);
        return new SaobracajnaMreza(putevi, raskrsnice, semafori);
    }

    private Boja nasumicnaBoja() {
        return RANDOM.nextBoolean() ? Boja.CRVENA : Boja.ZELENA;
    }

    private Vozilo nasumicnoVozilo() {
        int tip = RANDOM.nextInt(3);
        switch (tip) {
            case 0:
                return new Auto("Skoda", "Octavia", 3);
            case 1:
                return new Autobus("Mercedes", "Citaro", 1, "GSP");
            default:
                return new Tramvaj("Duewag", "GT6", 1, "GSP");
        }
    }
}
