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
public class Auto extends Vozilo {

    public Auto(TipVozila tipVozila) {
        super(tipVozila);
    }

    @Override
    public String tip() {
        return "Automobil";
    }

}
