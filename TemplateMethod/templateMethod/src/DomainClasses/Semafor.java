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
public class Semafor implements Serializable, GeneralDObject{
    Boja boja;
    Boja bojaPrethodnogKruga;
    int trajanjeUKrugovima;
    int brojKrugovaUTrenutnomStanju;

    public Semafor(Boja boja, int trajanjeUKrugovima) {
        this.boja = boja;
        this.bojaPrethodnogKruga = boja;
        this.trajanjeUKrugovima = trajanjeUKrugovima;
        this.brojKrugovaUTrenutnomStanju = 0;
    }

    public Boja getBoja() {
        return boja;
    }

    public Boja getBojaPrethodnogKruga() {
        return bojaPrethodnogKruga;
    }

    public int getTrajanjeUKrugovima() {
        return trajanjeUKrugovima;
    }

    public int getBrojKrugovaUTrenutnomStanju() {
        return brojKrugovaUTrenutnomStanju;
    }

    public boolean predvidjaSePromenaSledeceRunde() {
        return brojKrugovaUTrenutnomStanju + 1 >= trajanjeUKrugovima;
    }

    public void promeniBoju() {
        bojaPrethodnogKruga = boja;
        boja = boja.suprotna();
        brojKrugovaUTrenutnomStanju = 0;
    }

    public void produziTrenutnoStanje() {
        bojaPrethodnogKruga = boja;
        brojKrugovaUTrenutnomStanju++;
    }

}
