package Memento;

import DomainClasses.Boja;
import DomainClasses.Put;
import DomainClasses.Semafor;
import DomainClasses.Vozilo;
import java.util.List;
import java.util.Map;

public class Memento {

    public static class StanjeSemafora {
        private final Boja boja;
        private final Boja bojaPrethodnogKruga;
        private final int brojKrugovaUTrenutnomStanju;

        public StanjeSemafora(Boja boja, Boja bojaPrethodnogKruga, int brojKrugovaUTrenutnomStanju) {
            this.boja = boja;
            this.bojaPrethodnogKruga = bojaPrethodnogKruga;
            this.brojKrugovaUTrenutnomStanju = brojKrugovaUTrenutnomStanju;
        }

        public Boja getBoja() { return boja; }
        public Boja getBojaPrethodnogKruga() { return bojaPrethodnogKruga; }
        public int getBrojKrugovaUTrenutnomStanju() { return brojKrugovaUTrenutnomStanju; }
    }

    private final Map<Put, List<Vozilo>> vozilaPoUlici;
    private final Map<Semafor, StanjeSemafora> stanjaSemafora;

    public Memento(Map<Put, List<Vozilo>> vozilaPoUlici, Map<Semafor, StanjeSemafora> stanjaSemafora) {
        this.vozilaPoUlici = vozilaPoUlici;
        this.stanjaSemafora = stanjaSemafora;
    }

    public Map<Put, List<Vozilo>> getVozilaPoUlici() { return vozilaPoUlici; }
    public Map<Semafor, StanjeSemafora> getStanjaSemafora() { return stanjaSemafora; }

}
