package ConcreteCommand;

import Command.SistemskaOperacija;
import Receiver.PronadjiVozilo;

public class SOPronadji implements SistemskaOperacija { // ConcreteCommand
    PronadjiVozilo pv;

    public SOPronadji(PronadjiVozilo pv1) { pv = pv1; }

    @Override // execute(){receiver.action()}
    public void izvrsiSO() { pv.pronadjiVozilo(); }
}
