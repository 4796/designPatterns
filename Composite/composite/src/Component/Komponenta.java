package Component;

public abstract class Komponenta { // Component
   public void add(Komponenta kom){}
   public int getBrojKomponenti() {return 0;}
   public Komponenta getKomponenta(int i) {return null;}
   public Object getTipKomponente(){return null;}
}
