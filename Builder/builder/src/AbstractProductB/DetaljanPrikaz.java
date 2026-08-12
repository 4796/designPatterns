
package AbstractProductB;

import DomainClasses.Boja;
import DomainClasses.Put;
import DomainClasses.Raskrsnica;
import DomainClasses.Semafor;
import DomainClasses.Vozilo;

/**
 *
 * @author lazar
 */
public class DetaljanPrikaz extends Detaljnost{

    @Override
    public String infoSemafor(Raskrsnica r) {
        Semafor semafor = r.getSemafor();
        Boja sledeca = semafor.predvidjaSePromenaSledeceRunde()
                ? semafor.getBoja().suprotna()
                : semafor.getBoja();
        return "    Sledece  : [ " + sledeca.prikaz() + " ]\n";
    }

    @Override
    public String infoVozila(Put p) {
        if (p.getVozila().isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Vozilo v : p.getVozila()) {
            sb.append(String.format("    %-8s %-12s %s%n", v.getId(), v.tip(), v.toString()));
        }
        return sb.toString();
    }

}
