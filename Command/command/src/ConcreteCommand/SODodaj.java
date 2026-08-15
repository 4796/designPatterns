package ConcreteCommand;

import Command.SistemskaOperacija;
import Receiver.DodajVozilo;

public class SODodaj implements SistemskaOperacija { // ConcreteCommand
    DodajVozilo dv;

    public SODodaj(DodajVozilo dv1) { dv = dv1; }

    @Override // execute(){receiver.action()}
    public void izvrsiSO() { dv.dodajVozilo(); }
}
