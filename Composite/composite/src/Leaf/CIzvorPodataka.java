package Leaf;

import AbstractProductC.IzvorPodataka;

public class CIzvorPodataka extends List { // Leaf
   IzvorPodataka ip;
   public CIzvorPodataka(IzvorPodataka ip1){ip = ip1;}
   @Override
   public Object getTipKomponente(){return ip.getClass();}
}
