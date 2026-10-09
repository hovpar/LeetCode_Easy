package p257_binary_tree_paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
                arguments(Named.of("recursive return solver", new SolutionVariants.RecursiveReturn())),
                arguments(Named.of("dfs with string solver", new SolutionVariants.DFSWithString())),
                arguments(Named.of("srtringbuilder solver", new SolutionVariants.StringBuilderDFS())));
    }

    @TestEachSolver
    void testEmptyTree(SolutionVariants.Solver solver) {
        TreeNode root = null;

        List<String> result = solver.binaryTreePaths(root);
        assertTrue(result.isEmpty());
    }

    @TestEachSolver
    void testSingleNodeTree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1);

        List<String> result = solver.binaryTreePaths(root);

        assertEquals(List.of("1"), result);
    }

    @TestEachSolver
    void testTwoLevelTree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        List<String> result = solver.binaryTreePaths(root);

        // order may vary
        assertTrue(result.contains("1->2"));
        assertTrue(result.contains("1->3"));
        assertEquals(2, result.size());
    }

    @TestEachSolver
    void testLeftLeaningTree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(5), null), null);

        List<String> result = solver.binaryTreePaths(root);

        assertEquals(List.of("1->2->5"), result);
    }

    @TestEachSolver
    void testRightLeaningTree(SolutionVariants.Solver solver) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));

        List<String> result = solver.binaryTreePaths(root);

        assertEquals(List.of("1->2->3"), result);
    }

    @TestEachSolver
    void testGeneralTree(SolutionVariants.Solver solver) {
        //      1
        //     / \
        //    2   3
        //     \
        //      5
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));

        List<String> result = solver.binaryTreePaths(root);

        assertTrue(result.contains("1->2->5"));
        assertTrue(result.contains("1->3"));
        assertEquals(2, result.size());
    }

    @TestEachSolver
    void testLargeTree(SolutionVariants.Solver solver) {
        //      1
        //     / \
        //    2   3
        //   /   / \
        //  4   5   6
        //     /
        //    7
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));

        List<String> result = solver.binaryTreePaths(root);

        List<String> expected = List.of("1->2->4", "1->3->5->7", "1->3->6");

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

}
