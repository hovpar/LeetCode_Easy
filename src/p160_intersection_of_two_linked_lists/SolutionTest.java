package p160_intersection_of_two_linked_lists;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
                arguments(Named.of("length difference solver", new SolutionVariants.LengthDifferenceSolver())),
                arguments(Named.of("two pointer solver", new SolutionVariants.TwoPointerSolver())));
    }

    @TestEachSolver
    void intersectionWhenBLongerThanA(SolutionVariants.Solver solver) {

        ListNode commonList = new ListNode(8, (new ListNode(4, (new ListNode(5)))));

        ListNode listA = new ListNode(1, new ListNode(1, commonList));
        ListNode listB = new ListNode(5, new ListNode(6, new ListNode(1, commonList)));
        assertSame(commonList, solver.getIntersectionNode(listA, listB));

    }

    @TestEachSolver
    void intersectionWhenALongerThanB(SolutionVariants.Solver solver) {

        ListNode commonList = new ListNode(2, (new ListNode(4)));

        ListNode listA = new ListNode(1, new ListNode(1, new ListNode(1, commonList)));
        ListNode listB = new ListNode(3, commonList);
        assertSame(commonList, solver.getIntersectionNode(listA, listB));

    }

    @TestEachSolver
    void testNoIntersection(SolutionVariants.Solver solver) {
        ListNode listA = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listB = new ListNode(4, new ListNode(5));
        assertNull(solver.getIntersectionNode(listA, listB));
    }

    @TestEachSolver
    void testIntersectionAtHead(SolutionVariants.Solver solver) {
        ListNode commonList = new ListNode(7, new ListNode(8, new ListNode(9)));
        // Both lists start at the same node
        ListNode listA = commonList;
        ListNode listB = commonList;
        assertSame(commonList, solver.getIntersectionNode(listA, listB));
    }

    @TestEachSolver
    void testOneListEmpty(SolutionVariants.Solver solver) {
        ListNode listA = null;
        ListNode listB = new ListNode(1, new ListNode(2));
        assertNull(solver.getIntersectionNode(listA, listB));
    }

    @TestEachSolver
    void testBothEmpty(SolutionVariants.Solver solver) {
        ListNode listA = null;
        ListNode listB = null;
        assertNull(solver.getIntersectionNode(listA, listB));
    }

    @TestEachSolver
    void testIntersectionSingleNode(SolutionVariants.Solver solver) {
        ListNode commonList = new ListNode(10);
        ListNode listA = new ListNode(1, commonList);
        ListNode listB = new ListNode(2, commonList);
        assertSame(commonList, solver.getIntersectionNode(listA, listB));
    }

}
