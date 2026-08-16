package AbstractClass;

import AbstractProductA.Izvestaj;
import AbstractProductC.IzvorPodataka;
import DomainClasses.Put;
import java.util.List;


public abstract class Kontroler { // AbstractClass
    protected Izvestaj i;
    protected IzvorPodataka ip;
    protected String poruka;
    protected int brojTrenutnogKruga = 0;

    public final String simulirajJedanKrug() { // TemplateMethod
        brojTrenutnogKruga++;
        List<Put> putevi = ip.getPutevi();
        boolean fokusSemafori = ip.fokusMreza();

        StringBuilder sb = new StringBuilder();
        sb.append("Krug ").append(brojTrenutnogKruga).append(":\n");

        pomeriVozila(putevi, fokusSemafori, sb);
        azurirajSemafore(putevi, fokusSemafori, sb);

        return sb.toString();
    }

    protected abstract void pomeriVozila(List<Put> putevi, boolean fokusSemafori, StringBuilder sb);

    protected abstract void azurirajSemafore(List<Put> putevi, boolean fokusSemafori, StringBuilder sb);

}
