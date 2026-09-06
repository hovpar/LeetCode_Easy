package p203_remove_linked_list_elements;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest(name = "{0}")
    @MethodSource("solvers")
    @interface TestEachSolver {
    }

    static Stream<Arguments> solvers() {
        return Stream.of(
                arguments(Named.of("copy and filter solver", new SolutionVariants.CopyAndFilterSolver())),
                arguments(Named.of("in-place removal solver", new SolutionVariants.InPlaceRemovalSolver())));
    }

    @TestEachSolver
    void testDoubleOccurrence(SolutionVariants.Solver solver) {
        // origin: [1, 2, 6, 3, 4, 5, 6]
        ListNode origin = new ListNode(1,
                new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));

        // expected: [1, 2, 3, 4, 5]
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode result = solver.removeElements(origin, 6);

        assertTrue(equal(expected, result));
    }

    @TestEachSolver
    void testEmptyList(SolutionVariants.Solver solver) {
        ListNode origin = new ListNode();
        ListNode expected = new ListNode();

        ListNode result = solver.removeElements(origin, 1);
        assertTrue(equal(expected, result));
    }

    @TestEachSolver
    void testRemoveSameElement(SolutionVariants.Solver solver) {

        ListNode origin = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));

        ListNode result = solver.removeElements(origin, 7);
        assertTrue(equal(null, result));

    }

    @TestEachSolver
    void testNullList(SolutionVariants.Solver solver) {
        ListNode result = solver.removeElements(null, 1);
        assertNull(result);
    }

    @TestEachSolver
    void testTargetAtHead(SolutionVariants.Solver solver) {
        // [6,1,2,3] -> [1,2,3]
        ListNode origin = new ListNode(6, new ListNode(1, new ListNode(2, new ListNode(3))));
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3)));

        ListNode result = solver.removeElements(origin, 6);
        assertTrue(equal(expected, result));
    }

    @TestEachSolver
    void testTargetAtTail(SolutionVariants.Solver solver) {
        // [1,2,3,6] -> [1,2,3]
        ListNode origin = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(6))));
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3)));

        ListNode result = solver.removeElements(origin, 6);
        assertTrue(equal(expected, result));
    }

    @TestEachSolver
    void testNoRemoval(SolutionVariants.Solver solver) {
        // [1,2,3,4,5], remove 9 -> [1,2,3,4,5]
        ListNode origin = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode result = solver.removeElements(origin, 9);
        assertTrue(equal(expected, result));
    }

    private boolean equal(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.val != b.val) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return a == null && b == null;
    }

}
