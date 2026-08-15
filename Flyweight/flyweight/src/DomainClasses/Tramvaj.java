/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainClasses;

import Flyweight.TipVozila;

/**
 *
 * @author lazar
 */
public class Tramvaj extends Vozilo {
    String prevoznik;

    public Tramvaj(TipVozila tipVozila, String prevoznik) {
        super(tipVozila);
        this.prevoznik = prevoznik;
    }

    public String getPrevoznik() {
        return prevoznik;
    }

    @Override
    public String tip() {
        return "Tramvaj";
    }

    @Override
    public String toString() {
        return "Tramvaj " + super.toString()+" " + prevoznik;
    }
}
