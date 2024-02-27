import java.util.*;

public class CustomArrayListImpl<E> implements CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    transient Object[] elementData;
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = new Object[DEFAULT_CAPACITY];
    private int size;
    protected transient int modCount = 0;


    public CustomArrayListImpl() {
        this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }


    private Object[] grow() {
        return elementData = Arrays.copyOf(elementData, (int) (elementData.length * 1.5));
    }

    @Override
    public void add(int index, Object element) {
        rangeCheckForAdd(index);
        final int s = size;
        Object[] elementData = this.elementData;
        if (s >= elementData.length || s * 2 >= elementData.length) {
            elementData = grow();
        }
        System.arraycopy(elementData, index,
                elementData, index + 1,
                size > 0 ? size - 1 : 0);
        elementData[index] = element;
        size = s + 1;
    }

    private void rangeCheckForAdd(int index) {
        if (index > elementData.length || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0) {
            return false;
        }
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow();
        System.arraycopy(a, 0, elementData, s, numNew);
        size = s + numNew;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return elementData.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public void remove(int index) {
        elementData[index] = null;
    }

    @Override
    public boolean remove(Object o) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found:
        {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }

    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        Arrays.sort((E[]) elementData, 0, size, c);
    }
}
