package p145_binary_tree_postorder_traversal;

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
                arguments(Named.of("iterative solver", new SolutionVariants.IterativeSolver())),
                arguments(Named.of("reverse preorder solver", new SolutionVariants.ReversePreorderSolver())));
    }

    @TestEachSolver
    void traversesRightSkewedTreeInPostorder(SolutionVariants.Solver solver) {
        var three = new TreeNode(3);
        var two = new TreeNode(2, three, null);
        var root = new TreeNode(1, null, two);

        List<Integer> expected = List.of(3, 2, 1);
        assertEquals(expected, solver.postorderTraversal(root));
    }

    @TestEachSolver
    void visitsLeftSubtreeThenRightSubtreeThenRoot(SolutionVariants.Solver solver) {
        var four = new TreeNode(4);
        var six = new TreeNode(6);
        var seven = new TreeNode(7);
        var nine = new TreeNode(9);
        var five = new TreeNode(5, six, seven);
        var two = new TreeNode(2, four, five);
        var eight = new TreeNode(8, nine, null);
        var three = new TreeNode(3, null, eight);
        var root = new TreeNode(1, two, three);

        List<Integer> expected = List.of(4, 6, 7, 5, 2, 9, 8, 3, 1);
        assertEquals(expected, solver.postorderTraversal(root));
    }

    @TestEachSolver
    void returnsEmptyListForEmptyTree(SolutionVariants.Solver solver) {
        TreeNode root = null;

        List<Integer> expected = List.of();
        assertEquals(expected, solver.postorderTraversal(root));
    }

    @TestEachSolver
    void returnsRootValueForSingleNodeTree(SolutionVariants.Solver solver) {
        var root = new TreeNode(1);

        List<Integer> expected = List.of(1);
        assertEquals(expected, solver.postorderTraversal(root));
    }

}
