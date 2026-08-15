/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainClasses;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lazar
 */
public class SaobracajnaMreza implements Serializable, GeneralDObject{
    List<Put> putevi;
    List<Raskrsnica> raskrsnice;
    List<Semafor> semafori;

    public SaobracajnaMreza(List<Put> putevi, List<Raskrsnica> raskrsnice, List<Semafor> semafori) {
        this.putevi = putevi;
        this.raskrsnice = raskrsnice;
        this.semafori = semafori;
    }

    public List<Put> getPutevi() {
        return putevi;
    }

    public List<Raskrsnica> getRaskrsnice() {
        return raskrsnice;
    }

    public List<Semafor> getSemafori() {
        return semafori;
    }

}
