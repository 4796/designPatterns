package AbstractProductA;

import AbstractProductB.Detaljnost;
import Abstraction.IzvorPodataka;
import Abstraction.IzvorPodatakaOVozilima;
import DomainClasses.Put;



public class IzvestajOVozilima extends Izvestaj{

    public IzvestajOVozilima(Detaljnost d) {
        detaljnost=d;
    }

    @Override
    protected String naslov() {
        return "Izvestaj o vozilima";
    }

    @Override
    protected String telo(IzvorPodataka ip) {
        IzvorPodatakaOVozilima izvor = (IzvorPodatakaOVozilima) ip;
        StringBuilder sb = new StringBuilder();
        for (Put put : izvor.getPutevi()) {
            int brojVozila = izvor.getBrojVozila(put);
            sb.append(put.getNaziv()).append("   ").append(brojVozila).append(" vozila\n");
            sb.append(detaljnost.infoVozila(put));
        }
        sb.append("\nUkupno: ").append(izvor.getUkupanBrojVozila()).append(" vozila\n\n");
        return sb.toString();
    }

}
