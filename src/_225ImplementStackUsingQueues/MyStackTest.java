package _225ImplementStackUsingQueues;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTest {

    private MyStack stack;

    @BeforeEach
    void setup() {
        stack = new MyStack();
    }

    @Test
    void testPushAndTop() {
        stack.push(1);
        assertEquals(1, stack.top());

        stack.push(2);
        assertEquals(2, stack.top());

        stack.push(3);
        assertEquals(3, stack.top());
    }

    @Test
    void testPushAndPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    void testInterleavedOperations() {

        stack.push(5);
        stack.push(7);
        assertEquals(7, stack.top());
        assertEquals(7, stack.pop());

        stack.push(9);
        assertEquals(9, stack.top());
        assertEquals(9, stack.pop());

        assertEquals(5, stack.top());
        assertEquals(5, stack.pop());

        assertTrue(stack.empty());
    }

    @Test
    void testSingleElement() {
        stack.push(42);

        assertFalse(stack.empty());
        assertEquals(42, stack.top());
        assertEquals(42, stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    void testEmptyStack() {

        assertTrue(stack.empty());

        // pop/top won't be called on an empty stack.
        // But you can still test behavior:
        assertThrows(NullPointerException.class, stack::pop);
        assertThrows(NullPointerException.class, stack::top);
    }

    @Test
    void longSequenceTest() {

        for (int i = 1; i <= 1000; i++) {
            stack.push(i);
            assertEquals(i, stack.top());
        }

        for (int i = 1000; i >= 1; i--) {
            assertEquals(i, stack.pop());
        }

        assertTrue(stack.empty());
    }
}
