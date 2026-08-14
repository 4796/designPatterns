package ConcreteCommand;

import Command.SistemskaOperacija;
import Receiver.UkloniVozilo;

public class SOUkloni implements SistemskaOperacija { // ConcreteCommand
    UkloniVozilo uv;

    public SOUkloni(UkloniVozilo uv1) { uv = uv1; }

    @Override // execute(){receiver.action()}
    public void izvrsiSO() { uv.ukloniVozilo(); }
}
