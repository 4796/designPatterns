package AbstractProductC;

import DomainClasses.Put;
import DomainClasses.Vozilo;
import java.util.List;


public class IzvorPodatakaOVozilima extends IzvorPodataka
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
