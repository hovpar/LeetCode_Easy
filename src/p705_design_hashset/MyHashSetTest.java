package p705_design_hashset;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MyHashSetTest {

    @Test
    void shouldAddAndFindValues() {
        MyHashSet set = new MyHashSet();

        set.add(1);
        set.add(2);

        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertFalse(set.contains(3));
    }

    @Test
    void shouldIgnoreDuplicateAdditions() {
        MyHashSet set = new MyHashSet();

        set.add(2);
        set.add(2);

        assertTrue(set.contains(2));
    }

    @Test
    void shouldRemoveValues() {
        MyHashSet set = new MyHashSet();

        set.add(2);
        set.remove(2);

        assertFalse(set.contains(2));
    }

    @Test
    void shouldHandleRemovingNonexistentValues() {
        MyHashSet set = new MyHashSet();

        set.remove(5);

        assertFalse(set.contains(5));
    }

    @Test
    void shouldHandleRepeatedRemovals() {
        MyHashSet set = new MyHashSet();

        set.add(5);
        set.remove(5);
        set.remove(5);

        assertFalse(set.contains(5));
    }

    @Test
    void shouldAllowAddingValueAgainAfterRemoval() {
        MyHashSet set = new MyHashSet();

        set.add(5);
        set.remove(5);
        set.add(5);

        assertTrue(set.contains(5));
    }

    @Test
    void shouldHandleBoundaryKeys() {
        MyHashSet set = new MyHashSet();

        set.add(0);
        set.add(1_000_000);

        assertTrue(set.contains(0));
        assertTrue(set.contains(1_000_000));

        set.remove(0);
        set.remove(1_000_000);

        assertFalse(set.contains(0));
        assertFalse(set.contains(1_000_000));
    }

}
