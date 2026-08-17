package p101_symmetric_tree;

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
                arguments(Named.of("recursive solver", new SolutionVariants.RecursiveSolver())),
                arguments(Named.of("iterative solver", new SolutionVariants.IterativeSolver())));
    }

    @TestEachSolver
    void testSymmetricTree(SolutionVariants.Solver solver) {
        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        TreeNode root = new TreeNode(1, left, right);

        assertTrue(solver.isSymmetric(root));
    }

    @TestEachSolver
    void testAsymmetricTree(SolutionVariants.Solver solver) {
        TreeNode left = new TreeNode(2, new TreeNode(3), null);
        TreeNode right = new TreeNode(2, null, new TreeNode(3));
        TreeNode root = new TreeNode(1, left, right);

        assertTrue(solver.isSymmetric(root));
    }

    @TestEachSolver
    void testSingleRootNode(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1);
        assertTrue(solver.isSymmetric(root));
    }

    @TestEachSolver
    void testNullTree(SolutionVariants.Solver solver) {
        assertTrue(solver.isSymmetric(null));
    }

    @TestEachSolver
    void testOnlyLeftSubtree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertFalse(solver.isSymmetric(root));
    }

    @TestEachSolver
    void testOnlyRightSubtree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        assertFalse(solver.isSymmetric(root));
    }

    @TestEachSolver
    void testMirrorWithNullNodes(SolutionVariants.Solver solver) {
        TreeNode left = new TreeNode(2, null, new TreeNode(3));
        TreeNode right = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, left, right);

        assertTrue(solver.isSymmetric(root));
    }

}
