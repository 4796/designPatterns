package AbstractProductC;

import DomainClasses.Boja;
import DomainClasses.Raskrsnica;
import DomainClasses.Semafor;
import java.util.List;



public class IzvorPodatakaOMrezi extends IzvorPodataka
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
