/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lazar
 */
public class Put implements Serializable, GeneralDObject{
    String naziv;
    Raskrsnica sledecaRaskrsnica;
    List<Vozilo> vozilaPrethodnogKruga;
    List<Vozilo> vozila;

    public Put(String naziv) {
        this.naziv = naziv;
        this.vozila = new ArrayList<>();
        this.vozilaPrethodnogKruga = new ArrayList<>();
    }

    public String getNaziv() {
        return naziv;
    }

    public Raskrsnica getSledecaRaskrsnica() {
        return sledecaRaskrsnica;
    }

    public void setSledecaRaskrsnica(Raskrsnica sledecaRaskrsnica) {
        this.sledecaRaskrsnica = sledecaRaskrsnica;
    }

    public List<Vozilo> getVozila() {
        return vozila;
    }

    public void dodajVozilo(Vozilo v) {
        vozila.add(v);
        v.setPut(this);
    }

    @Override
    public String toString() {
        return naziv;
    }

}
