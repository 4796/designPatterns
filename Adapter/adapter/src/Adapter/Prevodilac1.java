package Adapter;

import Adaptee.Projektant;
import Target.Prevodilac;

public class Prevodilac1 extends Prevodilac{  // Adapter
    public Prevodilac1(Projektant pr1){super(pr1);}
    @Override
    public void kreirajIzvestaj(){pr.kreirajIzvestaj();}   
    @Override
    public void kreirajIzvorPodataka(){pr.kreirajIzvorPodataka();}
    @Override
    public void kreirajKontroler (){pr.kreirajKontroler();}
    @Override
    public void kreirajSistem(){pr.kreirajSoftverskiSistem();}
    @Override
    public void prikaziEkranskuFormu(){pr.prikaziEkranskuFormu();}

   
}
