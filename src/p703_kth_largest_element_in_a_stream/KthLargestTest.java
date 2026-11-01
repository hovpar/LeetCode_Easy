package p703_kth_largest_element_in_a_stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class KthLargestTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest(name = "{0}")
    @MethodSource("kthLargest")
    @interface TestEachSolver {
    }

    static Stream<Arguments> kthLargest() {
        return Stream.of(
                arguments(
                        "sorted list",
                        (BiFunction<Integer, int[], KthLargest>) SortedListBinarySearchKthLargest::new),
                arguments("min heap", (BiFunction<Integer, int[], KthLargest>) MinHeapKthLargest::new));
    }

    @TestEachSolver
    void shouldReturnKthLargestAfterEachAddition(String name, BiFunction<Integer, int[], KthLargest> factory) {

        KthLargest kthLargest = factory.apply(3, new int[] { 4, 5, 8, 2 });

        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5));
        assertEquals(5, kthLargest.add(10));
        assertEquals(8, kthLargest.add(9));
        assertEquals(8, kthLargest.add(4));
    }

    @TestEachSolver
    void shouldHandleDuplicateValues(String name, BiFunction<Integer, int[], KthLargest> factory) {

        KthLargest kthLargest = factory.apply(4, new int[] { 7, 7, 7, 7, 8, 3 });

        assertEquals(7, kthLargest.add(2));
        assertEquals(7, kthLargest.add(10));
        assertEquals(7, kthLargest.add(9));
        assertEquals(8, kthLargest.add(9));
    }

}
