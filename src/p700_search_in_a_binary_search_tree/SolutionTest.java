package p700_search_in_a_binary_search_tree;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

import common.TreeNode;

class SolutionTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest(name = "{0}")
    @MethodSource("solvers")
    @interface TestEachSolver {
    }

    static Stream<Arguments> solvers() {
        return Stream.of(
                arguments(Named.of("recursive solver", new SolutionVariants.RecursiveSolver())),
                arguments(Named.of("iterative solver", new SolutionVariants.IterativeSolver())));
    }

    @TestEachSolver
    void shouldHandleEmptyTree(SolutionVariants.Solver solver) {
        TreeNode root = null;
        assertEquals(null, solver.searchBST(root, 1));
    }

    @TestEachSolver
    void shouldReturnNullIfNodeNotExists(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1);
        assertEquals(null, solver.searchBST(root, 0));
    }

    @TestEachSolver
    void shouldReturnLeftSubTree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        assertEquals(root.left, solver.searchBST(root, 2));
    }

    @TestEachSolver
    void shouldReturnNullIfNodeDoesNotExistInRightSubtree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));

        assertNull(solver.searchBST(root, 5));
    }

    @TestEachSolver
    void shouldReturnRootWhenValueMatches(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(7));

        assertSame(root, solver.searchBST(root, 4));
    }

    @TestEachSolver
    void shouldReturnRightSubtree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(7));

        assertSame(root.right, solver.searchBST(root, 7));
    }

    @TestEachSolver
    void shouldReturnLeftmostNode(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));

        assertSame(root.left.left, solver.searchBST(root, 1));
    }

    @TestEachSolver
    void shouldReturnRightmostNode(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(7, null, new TreeNode(9)));

        assertSame(root.right.right, solver.searchBST(root, 9));
    }

    @TestEachSolver
    void shouldReturnNullWhenValueIsSmallerThanEveryNode(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(7));

        assertNull(solver.searchBST(root, -10));
    }

    @TestEachSolver
    void shouldReturnNullWhenValueIsGreaterThanEveryNode(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(7));

        assertNull(solver.searchBST(root, 10));
    }

    @TestEachSolver
    void shouldHandleSingleNodeTree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(5);

        assertSame(root, solver.searchBST(root, 5));
        assertNull(solver.searchBST(root, 3));
    }

    @TestEachSolver
    void shouldHandleSkewedTree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

        assertSame(root.right.right, solver.searchBST(root, 3));
        assertNull(solver.searchBST(root, 5));
    }

    @TestEachSolver
    void shouldHandleIntegerBoundaryValues(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(0, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE));

        assertSame(root.left, solver.searchBST(root, Integer.MIN_VALUE));
        assertSame(root.right, solver.searchBST(root, Integer.MAX_VALUE));
    }
}
