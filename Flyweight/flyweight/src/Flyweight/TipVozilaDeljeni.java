package Flyweight;

public class TipVozilaDeljeni implements TipVozila { // ConcreteFlyweight

    private final String marka;
    private final String model;
    private final int brzina;

    public TipVozilaDeljeni(String marka, String model, int brzina) {
        this.marka = marka;
        this.model = model;
        this.brzina = brzina;
    }

    @Override
    public String getMarka() { return marka; }

    @Override
    public String getModel() { return model; }

    @Override
    public int getBrzina() { return brzina; }

}
