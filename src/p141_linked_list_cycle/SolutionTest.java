package p141_linked_list_cycle;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
                arguments(Named.of("two pointer solver", new SolutionVariants.TwoPointerSolver())),
                arguments(Named.of("hashset solver", new SolutionVariants.HashSetSolver())));
    }

    @TestEachSolver
    void singleNode_noCycle(SolutionVariants.Solver solver) {
        ListNode head = new ListNode(1);
        assertFalse(solver.hasCycle(head));
    }

    @TestEachSolver
    void singleNode_withCycle(SolutionVariants.Solver solver) {
        ListNode head = new ListNode(1);
        head.next = head; // cycle to itself
        assertTrue(solver.hasCycle(head));
    }

    @TestEachSolver
    void multipleNodes_noCycle(SolutionVariants.Solver solver) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        assertFalse(solver.hasCycle(head));
    }

    @TestEachSolver
    void multipleNodes_withCycleAtEnd(SolutionVariants.Solver solver) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        node3.next = node2; // cycle back to node2
        assertTrue(solver.hasCycle(head));
    }

    @TestEachSolver
    void multipleNodes_cycleToHead(SolutionVariants.Solver solver) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        node3.next = head; // cycle back to head
        assertTrue(solver.hasCycle(head));
    }

    @TestEachSolver
    void multipleNodes_withCycle(SolutionVariants.Solver solver) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node3;
        node3.next = node2;
        node4.next = node2; // cycle back to node2
        assertTrue(solver.hasCycle(head));
    }

    @TestEachSolver
    void emptyList(SolutionVariants.Solver solver) {
        assertFalse(solver.hasCycle(null));
    }

}
