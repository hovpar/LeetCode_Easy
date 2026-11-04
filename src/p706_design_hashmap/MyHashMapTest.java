package p706_design_hashmap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyHashMapTest {

    @Test
    void shouldAddAndGetEntries() {
        MyHashMap hashmap = new MyHashMap();

        hashmap.put(1, 1);
        hashmap.put(2, 2);

        assertEquals(1, hashmap.get(1));
        assertEquals(2, hashmap.get(2));
    }

    @Test
    void shouldReturnMinusOneForNonExistingKey() {
        MyHashMap hashmap = new MyHashMap();

        assertEquals(-1, hashmap.get(3));
    }

    @Test
    void shouldUpdateExistingEntry() {
        MyHashMap hashmap = new MyHashMap();

        hashmap.put(2, 2);
        hashmap.put(2, 1);

        assertEquals(1, hashmap.get(2));
    }

    @Test
    void shouldRemoveEntry() {
        MyHashMap hashmap = new MyHashMap();

        hashmap.put(2, 2);
        hashmap.remove(2);

        assertEquals(-1, hashmap.get(2));
    }

    @Test
    void shouldNotAffectOtherEntriesWhenRemoving() {
        MyHashMap hashmap = new MyHashMap();

        hashmap.put(1, 10);
        hashmap.put(2, 20);
        hashmap.put(3, 30);

        hashmap.remove(2);

        assertEquals(10, hashmap.get(1));
        assertEquals(-1, hashmap.get(2));
        assertEquals(30, hashmap.get(3));
    }

    @Test
    void shouldHandleBoundaryKeys() {
        MyHashMap hashmap = new MyHashMap();

        hashmap.put(0, 100);
        hashmap.put(1_000_000, 200);

        assertEquals(100, hashmap.get(0));
        assertEquals(200, hashmap.get(1_000_000));
    }

    @Test
    void shouldAllowRemovingNonExistingKey() {
        MyHashMap hashmap = new MyHashMap();

        assertDoesNotThrow(() -> hashmap.remove(42));
        assertEquals(-1, hashmap.get(42));
    }

    @Test
    void shouldAllowReinsertingRemovedKey() {
        MyHashMap hashmap = new MyHashMap();

        hashmap.put(1, 100);
        hashmap.remove(1);
        hashmap.put(1, 200);

        assertEquals(200, hashmap.get(1));
    }

}
