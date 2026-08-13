package ConcreteImplementor;

import Implementor.GeneratorMreze;
import DomainClasses.Auto;
import DomainClasses.Autobus;
import DomainClasses.Boja;
import DomainClasses.Put;
import DomainClasses.Raskrsnica;
import DomainClasses.SaobracajnaMreza;
import DomainClasses.Semafor;
import DomainClasses.Tramvaj;
import DomainClasses.Vozilo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SlucajniGeneratorMreze implements GeneratorMreze // ConcreteImplementor
{
    private static final int BROJ_ULICA = 4;
    private static final Random RANDOM = new Random();

    @Override
    public SaobracajnaMreza izgradiMrezu() {
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

        for (Put put : putevi) {
            int brojVozila = 1 + RANDOM.nextInt(6);
            for (int j = 0; j < brojVozila; j++) {
                put.dodajVozilo(nasumicnoVozilo());
            }
        }

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
