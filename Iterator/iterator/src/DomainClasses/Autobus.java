/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainClasses;

/**
 *
 * @author lazar
 */
public class Autobus extends Vozilo {
    String prevoznik;

    public Autobus(String marka, String model, int brzina, String prevoznik) {
        super(marka, model, brzina);
        this.prevoznik = prevoznik;
    }

    public String getPrevoznik() {
        return prevoznik;
    }

    @Override
    public String tip() {
        return "Autobus";
    }

    @Override
    public String toString() {
        return "Autobus " + super.toString()+" " + prevoznik;
    }


}
