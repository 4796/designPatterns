package Composition;

import AbstractProductD.Kontroler;

public class CKontroler extends Kompozicija { // Composite
 Kontroler kon;
 public CKontroler(Kontroler kon1){kon=kon1;}
 @Override
 public Object getTipKomponente(){return kon.getClass();}
}
