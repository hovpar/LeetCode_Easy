package p094_binary_tree_inorder_traversal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
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
                arguments(Named.of("recursive solver", new SolutionVariants.RecursiveSolver())),
                arguments(Named.of("iterative solver", new SolutionVariants.IterativeSolver())));
    }

    @TestEachSolver
    void returnsEmptyListForEmptyTree(SolutionVariants.Solver solver) {
        assertEquals(List.of(), solver.inorderTraversal(null));
    }

    @TestEachSolver
    void returnsRootValueForSingleNodeTree(SolutionVariants.Solver solver) {
        var root = new TreeNode(1);

        assertEquals(List.of(1), solver.inorderTraversal(root));
    }

    @TestEachSolver
    void traversesSparseRightSubtreeInLeftRootRightOrder(SolutionVariants.Solver solver) {
        var root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        assertEquals(List.of(1, 3, 2), solver.inorderTraversal(root));
    }

    @TestEachSolver
    void traversesTreeContainingBothCompleteAndSparseSubtrees(SolutionVariants.Solver solver) {
        // LeetCode example:
        // [1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9]
        var root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))),
                new TreeNode(3, null, new TreeNode(8, new TreeNode(9), null)));

        assertEquals(List.of(4, 2, 6, 5, 7, 1, 3, 9, 8), solver.inorderTraversal(root));
    }

    @TestEachSolver
    void traversesLeftSkewedTreeFromLeafToRoot(SolutionVariants.Solver solver) {
        var root = new TreeNode(4, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null), null);

        assertEquals(List.of(1, 2, 3, 4), solver.inorderTraversal(root));
    }

    @TestEachSolver
    void traversesRightSkewedTreeFromRootToLeaf(SolutionVariants.Solver solver) {
        var root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

        assertEquals(List.of(1, 2, 3, 4), solver.inorderTraversal(root));
    }
}
