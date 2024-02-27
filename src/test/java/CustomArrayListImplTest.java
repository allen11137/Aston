import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class CustomArrayListImplTest {
    static CustomArrayListImpl<String> list = new CustomArrayListImpl<>();
    static CustomArrayListImpl<String> list1 = new CustomArrayListImpl<>();

    @BeforeEach
    void createLists() {
        list.add(0, "Svetlana");
        list.add(1, "Ivan");
        list.add(2, "Anastacia");
        list.add(3, "Vladislav");
        list.add(4, "Polina");
        list.add(5, "Konstantin");
        list1.add(0, "Svetlana");
        list1.add(1, "Ivan");
        list1.add(2, "Anastacia");
        list1.add(3, "Vladislav");
        list1.add(4, "Polina");
        list1.add(5, "Konstantin");
    }


    @Test
    @Order(1)
    void add() {
        list.add(5, "Alina");
        Assertions.assertEquals("Alina", list.get(5));
    }

    @Order(2)
    @Test
    void addAll() {
        list.addAll(list1);
        Assertions.assertEquals(list.size(), list.size() + list1.size());
    }

    @Order(7)
    @Test
    void clear() {
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Order(3)
    @Test
    void get() {
        list.get(5);
        Assertions.assertEquals("Konstantin", list.get(5));
    }

    @Order(4)
    @Test
    void isEmpty() {
        list.isEmpty();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void remove() {
        list.remove("Polina");
        Assertions.assertEquals(null, list.get(5));
    }

    @Test
    void testRemove() {
        list.remove(4);
        Assertions.assertEquals(null, list.get(4));
    }

    @Test
    void sort() {
        list.sort(Comparator.comparing(String::valueOf));
        System.out.println("+++++++++++++++++++++++++++");
        Assertions.assertEquals("Anastacia", list.elementData[0]);
    }
}