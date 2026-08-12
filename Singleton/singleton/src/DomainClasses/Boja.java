/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package DomainClasses;

/**
 *
 * @author lazar
 */
public enum Boja {
    CRVENA, ZELENA;

    public Boja suprotna() {
        return this == CRVENA ? ZELENA : CRVENA;
    }

    public String prikaz() {
        return this == CRVENA ? "CRVENO" : "ZELENO";
    }
}
