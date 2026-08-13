package Abstraction;

import DomainClasses.Boja;
import DomainClasses.Raskrsnica;
import DomainClasses.Semafor;
import DomainClasses.SaobracajnaMreza;
import Implementor.GeneratorMreze;
import java.util.List;



public class IzvorPodatakaOMrezi extends IzvorPodataka // Abstraction
{

    public IzvorPodatakaOMrezi()
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
        return true;
    }


    public List<Raskrsnica> getRaskrsnice() {
        return saobracajnaMreza.getRaskrsnice();
    }


    public int getBrojZelenih() {
        int broj = 0;
        for (Semafor semafor : getSemafori()) {
            if (semafor.getBoja() == Boja.ZELENA) {
                broj++;
            }
        }
        return broj;
    }

}
