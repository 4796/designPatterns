/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainClasses;

import java.io.Serializable;

/**
 *
 * @author lazar
 */
public class Raskrsnica implements Serializable, GeneralDObject{
    String oznaka;
    Semafor semafor;
    Put naredniPut;

    public Raskrsnica(String oznaka, Semafor semafor) {
        this.oznaka = oznaka;
        this.semafor = semafor;
    }

    public String getOznaka() {
        return oznaka;
    }

    public Semafor getSemafor() {
        return semafor;
    }

    public Put getNaredniPut() {
        return naredniPut;
    }

    public void setNaredniPut(Put naredniPut) {
        this.naredniPut = naredniPut;
    }

}
