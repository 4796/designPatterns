package Mediator;

import Colleaque.Colleague;
import DomainClasses.Boja;
import DomainClasses.Raskrsnica;
import DomainClasses.Vozilo;

public interface Mediator {
    void zatraziPromenu(Colleague posiljalac, Boja zeljenaBoja);
    void zatraziKoridor(Raskrsnica pocetna, int duzina);
    int brojKolega();
    String prinudnoPostaviSemafor(int indeks, Boja zeljenaBoja);
    void pratiVozilo(Vozilo vozilo);
    void pripremiSemaforeAkoPratimoVozilo();
}
