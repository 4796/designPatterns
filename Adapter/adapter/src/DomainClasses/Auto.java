/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainClasses;

/**
 *
 * @author lazar
 */
public class Auto extends Vozilo {

    public Auto(String marka, String model, int brzina) {
        super(marka, model, brzina);
    }

    @Override
    public String tip() {
        return "Automobil";
    }

}
