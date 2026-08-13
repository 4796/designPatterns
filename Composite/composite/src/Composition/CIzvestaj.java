package Composition;

import AbstractProductA.Izvestaj;

public class CIzvestaj extends Kompozicija { // Composite
 Izvestaj i;
 public CIzvestaj(Izvestaj i1){i=i1;}
 @Override
 public Object getTipKomponente(){return i.getClass();}
}
