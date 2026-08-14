/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainClasses;

import Flyweight.TipVozila;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author lazar
 */
public abstract class Vozilo implements Serializable, GeneralDObject {

    private static final AtomicInteger BROJAC = new AtomicInteger(1);

    String id;
    TipVozila tipVozila;
    Put put;

    public Vozilo(TipVozila tipVozila) {
        this.id = String.format("V%03d", BROJAC.getAndIncrement());
        this.tipVozila = tipVozila;
    }

    public abstract String tip();

    public String getId() {
        return id;
    }

    public String getMarka() {
        return tipVozila.getMarka();
    }

    public String getModel() {
        return tipVozila.getModel();
    }

    public int getBrzina() {
        return tipVozila.getBrzina();
    }

    public Put getPut() {
        return put;
    }

    public void setPut(Put put) {
        this.put = put;
    }

    @Override
    public String toString() {
        return getMarka() + " " + getModel();
    }

}
