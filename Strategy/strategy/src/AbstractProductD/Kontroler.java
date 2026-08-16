package AbstractProductD;

import AbstractProductA.Izvestaj;
import AbstractProductC.IzvorPodataka;
import Strategy.NacinSimulacije;


public class Kontroler { // Context
    Izvestaj i;
    IzvorPodataka ip;
    String poruka;
    protected int brojTrenutnogKruga = 0;
    private NacinSimulacije nacinSimulacije;

    public Kontroler(Izvestaj i1, IzvorPodataka ip1, NacinSimulacije nacinSimulacije1) {
        i = i1;
        ip = ip1;
        nacinSimulacije = nacinSimulacije1;
    }

    public void setNacinSimulacije(NacinSimulacije nacinSimulacije1) {
        nacinSimulacije = nacinSimulacije1;
    }

    public String simulirajJedanKrug() {
        brojTrenutnogKruga++;
        return nacinSimulacije.simuliraj(ip, ip.fokusMreza(), brojTrenutnogKruga);
    }

}
