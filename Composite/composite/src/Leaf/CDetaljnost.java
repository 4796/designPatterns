package Leaf;

import AbstractProductB.Detaljnost;

public class CDetaljnost extends List { // Leaf
 Detaljnost det;
 public CDetaljnost(Detaljnost det1) {det = det1;}
 @Override
 public Object getTipKomponente(){return det.getClass();}
}
