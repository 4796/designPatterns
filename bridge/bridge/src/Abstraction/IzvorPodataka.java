package Abstraction;

import DomainClasses.Put;
import DomainClasses.Semafor;
import DomainClasses.SaobracajnaMreza;
import java.util.List;

public abstract class IzvorPodataka // Abstraction
{
    protected SaobracajnaMreza saobracajnaMreza;

    public abstract boolean fokusMreza();

    protected abstract SaobracajnaMreza izgradiMrezu();

    public List<Put> getPutevi() {
        return saobracajnaMreza.getPutevi();
    }

    public List<Semafor> getSemafori() {
        return saobracajnaMreza.getSemafori();
    }
}
