package Direktor;

import builder.Projektant;
import builder.ProjektantJednostavnogIzvestajaOMrezi;


public class KorisnikSistema { // 
        Projektant proj; //  


public KorisnikSistema (){proj = new ProjektantJednostavnogIzvestajaOMrezi(); }

public void kreirajSoftverskiSistem() {proj.kreirajSoftverskiSistem();}
public void kreirajEkranskuFormu() { proj.kreirajIzvestaj();}
public void kreirajIzvorPodataka(){ proj.kreirajIzvorPodataka();}
public void kreirajKontroler(){ proj.kreirajKontroler();}
public void prikaziEkranskuFormu (){ proj.prikaziEkranskuFormu();}




}
