package AbstractProductA;

import AbstractProductB.Detaljnost;
import AbstractProductC.IzvorPodataka;
import AbstractProductC.IzvorPodatakaOMrezi;
import DomainClasses.Put;
import DomainClasses.Raskrsnica;



public class IzvestajOMrezi extends Izvestaj{

    public IzvestajOMrezi(Detaljnost d) {
        detaljnost=d;
    }

    @Override
    protected String naslov() {
        return "Izvestaj o semaforima";
    }

    @Override
    protected String telo(IzvorPodataka ip) {
        IzvorPodatakaOMrezi izvor = (IzvorPodatakaOMrezi) ip;
        StringBuilder sb = new StringBuilder();
        sb.append("Trenutno zelenih semafora: ").append(izvor.getBrojZelenih())
          .append("/").append(izvor.getPutevi().size()).append("\n\n");
        for (Put put : izvor.getPutevi()) {
            Raskrsnica r = put.getSledecaRaskrsnica();
            sb.append(r.getOznaka()).append("  ").append(put.getNaziv())
              .append(" -> ").append(r.getNaredniPut().getNaziv()).append("\n");
            sb.append("    Trenutno : [ ").append(r.getSemafor().getBoja().prikaz()).append(" ]\n");
            sb.append(detaljnost.infoSemafor(r));
            sb.append("\n");
        }
        return sb.toString();
    }

}
