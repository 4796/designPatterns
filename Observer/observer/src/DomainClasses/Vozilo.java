/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainClasses;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author lazar
 */
public abstract class Vozilo implements Serializable, GeneralDObject {

    private static final AtomicInteger BROJAC = new AtomicInteger(1);

    String id;
    String marka;
    String model;
    int brzina;
    Put put;

    public Vozilo(String marka, String model, int brzina) {
        this.id = String.format("V%03d", BROJAC.getAndIncrement());
        this.marka = marka;
        this.model = model;
        this.brzina = brzina;
    }

    public abstract String tip();

    public String getId() {
        return id;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getBrzina() {
        return brzina;
    }

    public void setBrzina(int brzina) {
        this.brzina = brzina;
    }

    public Put getPut() {
        return put;
    }

    public void setPut(Put put) {
        this.put = put;
    }

    @Override
    public String toString() {
        return marka + " " + model;
    }

}
