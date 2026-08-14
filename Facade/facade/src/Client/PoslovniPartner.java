package Client;

import Direktor.*;
import java.util.Scanner;



public class PoslovniPartner { // Client
        KorisnikSistema sef;   
        
PoslovniPartner (KorisnikSistema sef1){sef=sef1; }  



public static void main(String args[])  {
    PoslovniPartner pp;  
    KorisnikSistema sef = new KorisnikSistema();
    pp = new PoslovniPartner(sef);
    pp.Konstruisi();
    //sef.prikaziEkranskuFormu();
    boolean krajPrograma = false;
    Scanner unos = new Scanner(System.in);
    while (!krajPrograma) {
        System.out.println();
        System.out.println("=== Simulacija saobracajnih tokova ===");

        sef.prikaziEkranskuFormu();
        System.out.println();
        System.out.print("Nova simulacija? (d/n): ");
        String nastavak = unos.nextLine().trim();
        krajPrograma = !nastavak.equalsIgnoreCase("d");
    }
}



void Konstruisi()     {   
      sef.kreirajSoftverskiSistem();
      sef.kreirajEkranskuFormu();
      sef.kreirajIzvorPodataka();
      sef.kreirajKontroler();
      
} 



    
}
