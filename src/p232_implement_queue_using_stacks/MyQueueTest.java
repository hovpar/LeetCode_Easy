package p232_implement_queue_using_stacks;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest {

    private MyQueue q;

    @BeforeEach
    void setup() {
        q = new MyQueue();
    }

    @Test
    void testPushAndPeek() {
        q.push(1);
        assertEquals(1, q.peek());

        q.push(2);
        assertEquals(1, q.peek());

        q.push(3);
        assertEquals(1, q.peek());
    }

    @Test
    void testPushAndPop() {
        q.push(10);
        q.push(20);
        q.push(30);

        assertEquals(10, q.pop());
        assertEquals(20, q.pop());
        assertEquals(30, q.pop());
        assertTrue(q.empty());
    }

    @Test
    void testReusingAfterEmptying() {
        q.push(5);
        q.push(6);

        assertEquals(5, q.pop());
        assertEquals(6, q.pop());
        assertTrue(q.empty());

        q.push(7); // reuse after empty
        assertFalse(q.empty());
        assertEquals(7, q.peek());
    }

    @Test
    void testAlternatePushPop() {
        q.push(1);
        assertEquals(1, q.pop());

        q.push(2);
        q.push(3);
        assertEquals(2, q.pop());

        q.push(4);
        assertEquals(3, q.pop());
        assertEquals(4, q.pop());
        assertTrue(q.empty());
    }

    @Test
    void testLargeSequentialOperations() {
        for (int i = 1; i <= 1000; i++) {
            q.push(i);
        }

        for (int i = 1; i <= 1000; i++) {
            assertEquals(i, q.pop());
        }

        assertTrue(q.empty());
    }

    @Test
    void testPeekAfterPops() {
        q.push(10);
        q.push(20);
        q.push(30);

        assertEquals(10, q.pop());
        assertEquals(20, q.peek());
        assertEquals(20, q.pop());
        assertEquals(30, q.peek());
    }

    @Test
    void testEmptyStates() {
        assertTrue(q.empty());

        q.push(1);
        assertFalse(q.empty());

        q.pop();
        assertTrue(q.empty());

        q.push(2);
        q.push(3);
        assertFalse(q.empty());
    }

    @Test
    void testComplexOperationOrder() {
        q.push(100);
        q.push(200);
        assertEquals(100, q.pop()); // first pop

        q.push(300);
        q.push(400);

        assertEquals(200, q.pop()); // check ordering
        assertEquals(300, q.peek());
        assertEquals(300, q.pop());

        q.push(500);
        assertFalse(q.empty());
        assertEquals(400, q.pop());
        assertEquals(500, q.pop());

        assertTrue(q.empty());
    }

}
