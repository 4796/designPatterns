package ConcreteClass;

import AbstractClass.Kontroler;
import AbstractProductA.Izvestaj;
import AbstractProductC.IzvorPodataka;
import DomainClasses.Boja;
import DomainClasses.Put;
import DomainClasses.Raskrsnica;
import DomainClasses.Semafor;
import DomainClasses.Vozilo;
import java.util.ArrayList;
import java.util.List;


public final class JednostavanKontroler extends Kontroler { // ConcreteClass

    public JednostavanKontroler(Izvestaj i1, IzvorPodataka ip1) { i = i1; ip = ip1; }

    @Override
    protected void pomeriVozila(List<Put> putevi, boolean fokusSemafori, StringBuilder sb) {
        // snapshot vozila i boja po ulici pre bilo kakvog pomeranja u ovom krugu
        List<List<Vozilo>> snapshotVozila = new ArrayList<>();
        List<Boja> snapshotBoja = new ArrayList<>();
        for (Put put : putevi) {
            snapshotVozila.add(new ArrayList<>(put.getVozila()));
            snapshotBoja.add(put.getSledecaRaskrsnica().getSemafor().getBoja());
        }

        for (int idx = 0; idx < putevi.size(); idx++) {
            Put put = putevi.get(idx);
            Raskrsnica r = put.getSledecaRaskrsnica();
            List<Vozilo> polazna = snapshotVozila.get(idx);
            boolean zeleno = snapshotBoja.get(idx) == Boja.ZELENA;

            if (zeleno) {
                put.getVozila().removeAll(polazna);
                for (Vozilo v : polazna) {
                    r.getNaredniPut().dodajVozilo(v);
                }
            }

            if (fokusSemafori) {
                sb.append("  ").append(r.getOznaka()).append(": ")
                  .append(snapshotBoja.get(idx).prikaz()).append(" -> ")
                  .append(snapshotBoja.get(idx).suprotna().prikaz()).append("\n");
            } else if (zeleno) {
                sb.append("  ").append(put.getNaziv()).append(" -> ").append(r.getNaredniPut().getNaziv())
                  .append(": ").append(polazna.size()).append(" vozila preslo\n");
            } else {
                sb.append("  ").append(put.getNaziv())
                  .append(": prolaz zatvoren, ").append(polazna.size()).append(" vozila ceka\n");
            }
        }
    }

    @Override
    protected void azurirajSemafore(List<Put> putevi, boolean fokusSemafori, StringBuilder sb) {
        for (Semafor semafor : ip.getSemafori()) {
            semafor.promeniBoju();
        }
    }

}
