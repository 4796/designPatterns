package Iterator;

import java.util.List;
import java.util.function.Supplier;

public class ListaIterator<T> implements Iterator<T> {
    private final Supplier<List<T>> izvor; 
    private int trenutniIndeks = -1;

    public ListaIterator(Supplier<List<T>> izvor1) { izvor = izvor1; }

    @Override
    public T first() {
        List<T> lista = izvor.get();
        if (lista.isEmpty()) { trenutniIndeks = -1; return null; }
        trenutniIndeks = 0;
        return lista.get(trenutniIndeks);
    }

    @Override
    public T next() {
        List<T> lista = izvor.get();
        if (lista.isEmpty()) { trenutniIndeks = -1; return null; }
        if (trenutniIndeks < 0 || trenutniIndeks >= lista.size()) {
            trenutniIndeks = 0;
        } else if (trenutniIndeks + 1 < lista.size()) {
            trenutniIndeks++;
        }
        return lista.get(trenutniIndeks);
    }

    @Override
    public T previous() {
        List<T> lista = izvor.get();
        if (lista.isEmpty()) { trenutniIndeks = -1; return null; }
        if (trenutniIndeks < 0 || trenutniIndeks >= lista.size()) {
            trenutniIndeks = lista.size() - 1;
        } else if (trenutniIndeks - 1 >= 0) {
            trenutniIndeks--;
        }
        return lista.get(trenutniIndeks);
    }

    @Override
    public T last() {
        List<T> lista = izvor.get();
        if (lista.isEmpty()) { trenutniIndeks = -1; return null; }
        trenutniIndeks = lista.size() - 1;
        return lista.get(trenutniIndeks);
    }

}
