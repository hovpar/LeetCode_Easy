package p225_implement_stack_using_queues;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MyStackTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest(name = "{0}")
    @MethodSource("stacks")
    @interface TestEachSolver {
    }

    static Stream<Arguments> stacks() {
        return Stream.of(
                arguments("two queues", (Supplier<MyStack>) TwoQueuesStack::new),
                arguments("one queue", (Supplier<MyStack>) OneQueueStack::new));
    }

    @TestEachSolver
    void testPushAndTop(String name, Supplier<MyStack> factory) {
        MyStack stack = factory.get();

        stack.push(1);
        assertEquals(1, stack.top());

        stack.push(2);
        assertEquals(2, stack.top());

        stack.push(3);
        assertEquals(3, stack.top());
    }

    @TestEachSolver
    void testPushAndPop(String name, Supplier<MyStack> factory) {
        MyStack stack = factory.get();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.empty());
    }

    @TestEachSolver
    void testInterleavedOperations(String name, Supplier<MyStack> factory) {
        MyStack stack = factory.get();

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

    @TestEachSolver
    void testSingleElement(String name, Supplier<MyStack> factory) {
        MyStack stack = factory.get();

        stack.push(42);

        assertFalse(stack.empty());
        assertEquals(42, stack.top());
        assertEquals(42, stack.pop());
        assertTrue(stack.empty());
    }

    @TestEachSolver
    void testEmptyStack(String name, Supplier<MyStack> factory) {
        MyStack stack = factory.get();

        assertTrue(stack.empty());

        // pop/top won't be called on an empty stack.
        // But you can still test behavior:
        assertThrows(NullPointerException.class, stack::pop);
        assertThrows(NullPointerException.class, stack::top);
    }

    @TestEachSolver
    void longSequenceTest(String name, Supplier<MyStack> factory) {
        MyStack stack = factory.get();

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
