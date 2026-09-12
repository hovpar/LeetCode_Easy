package p234_palindrome_linked_list;

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
                arguments(Named.of("stack solver", new SolutionVariants.StackSolver())),
                arguments(Named.of("two-pointer solver", new SolutionVariants.TwoPointerSolver())));
    }

    @TestEachSolver
    void returnsTrueForEvenLengthPalindrome(SolutionVariants.Solver solver) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        assertTrue(solver.isPalindrome(head));
    }

    @TestEachSolver
    void returnsFalseForNonPalindrome(SolutionVariants.Solver solver) {
        ListNode head = new ListNode(1, new ListNode(2));
        assertFalse(solver.isPalindrome(head));
    }

    @TestEachSolver
    void returnsFalseForNearPalindrome(SolutionVariants.Solver solver) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))));
        assertFalse(solver.isPalindrome(head));
    }

    @TestEachSolver
    void returnsTrueForSingleNode(SolutionVariants.Solver solver) {
        ListNode head = new ListNode(5);
        assertTrue(solver.isPalindrome(head));
    }

    @TestEachSolver
    void returnsTrueForOddLengthPalindrome(SolutionVariants.Solver solver) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
        assertTrue(solver.isPalindrome(head));
    }

    @TestEachSolver
    void returnsTrueForEmptyList(SolutionVariants.Solver solver) {
        assertTrue(solver.isPalindrome(null));
    }

    @TestEachSolver
    void returnsTrueForLongPalindrome(SolutionVariants.Solver solver) {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(3, new ListNode(1)))));
        assertTrue(solver.isPalindrome(head));
    }

}
