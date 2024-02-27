import java.util.Collection;
import java.util.Comparator;


public interface CustomArrayList<E> extends Collection<E> {

    void add(int index, E element);

    boolean addAll(Collection<? extends E> c);

    void clear();

    E get(int index);

    boolean isEmpty();

    void remove(int index);

    boolean remove(Object o);

    void sort(Comparator<? super E> c);


}
