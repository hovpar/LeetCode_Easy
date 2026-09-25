package p653_two_sum_iv_input_is_a_bst;

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
                arguments(Named.of("hashset solver", new SolutionVariants.HashSetSolver())),
                arguments(Named.of("two-pointer solver", new SolutionVariants.TwoPointerSolver())));
    }

    @TestEachSolver
    void shouldFindPair(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7)));

        assertTrue(solver.findTarget(root, 9));
    }

    @TestEachSolver
    void shouldReturnFalseWhenNoPairExists(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7)));

        assertFalse(solver.findTarget(root, 28));
    }

    @TestEachSolver
    void shouldFindPairInLeftSubtree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(2), new TreeNode(7)), new TreeNode(15));

        assertTrue(solver.findTarget(root, 9));
    }

    @TestEachSolver
    void shouldFindPairInRightSubtree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(10, new TreeNode(5), new TreeNode(15, new TreeNode(12), new TreeNode(20)));

        assertTrue(solver.findTarget(root, 32));
    }

    @TestEachSolver
    void shouldFindPairUsingRoot(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(10, new TreeNode(5), new TreeNode(15));

        assertTrue(solver.findTarget(root, 25));
    }

    @TestEachSolver
    void shouldReturnFalseForSingleNode(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(5);

        assertFalse(solver.findTarget(root, 10));
    }

    @TestEachSolver
    void shouldReturnFalseForEmptyTree(SolutionVariants.Solver solver) {
        assertFalse(solver.findTarget(null, 10));
    }

    @TestEachSolver
    void shouldHandleDuplicateValues(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(5, new TreeNode(3), new TreeNode(3));

        assertTrue(solver.findTarget(root, 6));
    }

    @TestEachSolver
    void shouldNotUseSameNodeTwice(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(5);

        assertFalse(solver.findTarget(root, 10));
    }

    @TestEachSolver
    void shouldHandleZero(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(0, new TreeNode(-3), new TreeNode(3));

        assertTrue(solver.findTarget(root, 0));
    }

    @TestEachSolver
    void shouldHandleNegativeValues(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(-5, new TreeNode(-10), new TreeNode(-2));

        assertTrue(solver.findTarget(root, -12));
    }

    @TestEachSolver
    void shouldFindNegativeAndPositivePair(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(5, new TreeNode(-3), new TreeNode(10));

        assertTrue(solver.findTarget(root, 2));
    }

    @TestEachSolver
    void shouldReturnFalseWhenTargetRequiresUnavailableValue(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(8, new TreeNode(3), new TreeNode(10));

        assertFalse(solver.findTarget(root, 100));
    }

    @TestEachSolver
    void shouldHandlePairOfEqualValues(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(5, new TreeNode(3), new TreeNode(3));

        assertTrue(solver.findTarget(root, 6));
    }

}
