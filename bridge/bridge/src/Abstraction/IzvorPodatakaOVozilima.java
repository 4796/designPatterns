package Abstraction;

import DomainClasses.Put;
import DomainClasses.Vozilo;
import DomainClasses.SaobracajnaMreza;
import Implementor.GeneratorMreze;
import java.util.List;


public class IzvorPodatakaOVozilima extends IzvorPodataka // Abstraction
{

    public IzvorPodatakaOVozilima()
    {
        makeConnection();
    }

    public void makeConnection()
    {
        saobracajnaMreza = izgradiMrezu();
    }

    @Override
    protected SaobracajnaMreza izgradiMrezu() {
        GeneratorMreze generator = vratiGenerator();
        return generator == null ? null : generator.izgradiMrezu();
    }

    protected GeneratorMreze vratiGenerator() { return null; } // Promenljivo!!!

    @Override
    public boolean fokusMreza() {
        return false;
    }

    public List<Vozilo> getVozilaNaUlici(Put p) {
        return p.getVozila();
    }

    public int getBrojVozila(Put p) {
        return p.getVozila().size();
    }

    public int getUkupanBrojVozila() {
        int ukupno = 0;
        for (Put put : getPutevi()) {
            ukupno += put.getVozila().size();
        }
        return ukupno;
    }

}
