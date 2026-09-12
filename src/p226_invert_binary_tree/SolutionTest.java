package p226_invert_binary_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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
                arguments(Named.of("recursive solver", new SolutionVariants.RecursiveSolver())),
                arguments(Named.of("iterative solver", new SolutionVariants.IterativeSolver())));
    }

    @TestEachSolver
    void testNullTree(SolutionVariants.Solver solver) {

        assertNull(solver.invertTree(null));
    }

    @TestEachSolver
    void testSingleNode(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1);

        TreeNode result = solver.invertTree(root);

        assertEquals(1, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @TestEachSolver
    void testTwoNodesLeft(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);

        TreeNode result = solver.invertTree(root);

        assertNull(result.left);
        assertNotNull(result.right);
        assertEquals(2, result.right.val);
    }

    @TestEachSolver
    void testTwoNodesRight(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1, null, new TreeNode(3));

        TreeNode result = solver.invertTree(root);

        assertNull(result.right);
        assertNotNull(result.left);
        assertEquals(3, result.left.val);
    }

    @TestEachSolver
    void testFullTree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        TreeNode result = solver.invertTree(root);

        assertEquals(7, result.left.val);
        assertEquals(9, result.left.left.val);
        assertEquals(6, result.left.right.val);

        assertEquals(2, result.right.val);
        assertEquals(3, result.right.left.val);
        assertEquals(1, result.right.right.val);
    }

}
