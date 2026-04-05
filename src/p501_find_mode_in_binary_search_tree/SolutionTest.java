package p501_find_mode_in_binary_search_tree;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest
    @MethodSource("solvers")
    @interface SolverTest {
    }

    static Stream<SolutionVariants.Solver> solvers() {
        return Stream.of(new SolutionVariants.InorderTraversalSolver(), new SolutionVariants.HashMapFrequencySolver());
    }

    @SolverTest
    void shouldReturnEmptyArrayForNullTree(SolutionVariants.Solver s) {
        assertArrayEquals(new int[0], s.findMode(null));
    }

    @SolverTest
    void shouldReturnSingleValueForSingleNodeTree(SolutionVariants.Solver s) {
        TreeNode root = n(1);

        assertArrayEquals(new int[] { 1 }, s.findMode(root));
    }

    @SolverTest
    void shouldReturnSingleModeForExampleLikeCase(SolutionVariants.Solver s) {
        //     2
        //    / \
        //   1   2
        TreeNode root = n(2, n(1), n(2));

        assertArrayEquals(new int[] { 2 }, s.findMode(root));
    }

    @SolverTest
    void shouldReturnAllValuesWhenEveryValueAppearsOnce(SolutionVariants.Solver s) {
        //     2
        //    / \
        //   1   3
        TreeNode root = n(2, n(1), n(3));

        assertArrayEquals(new int[] { 1, 2, 3 }, s.findMode(root));
    }

    @SolverTest
    void shouldReturnTwoModesWhenBothHaveSameHighestFrequency(SolutionVariants.Solver s) {
        //         2
        //        / \
        //       1   3
        //        \   \
        //         1   3
        TreeNode root = n(2, n(1, null, n(1)), n(3, null, n(3)));

        assertArrayEquals(new int[] { 1, 3 }, s.findMode(root));
    }

    @SolverTest
    void shouldReturnModeWhenDuplicatesAreOnLeftChain(SolutionVariants.Solver s) {
        //     2
        //    /
        //   2
        //  /
        // 2
        TreeNode root = n(2, n(2, n(2), null), null);

        assertArrayEquals(new int[] { 2 }, s.findMode(root));
    }

    @SolverTest
    void shouldReturnModeWhenDuplicatesAreOnRightChain(SolutionVariants.Solver s) {
        // 1
        //  \
        //   2
        //    \
        //     2
        //      \
        //       2
        TreeNode root = n(1, null, n(2, null, n(2, null, n(2))));

        assertArrayEquals(new int[] { 2 }, s.findMode(root));
    }

    @SolverTest
    void shouldReturnNegativeValueAsMode(SolutionVariants.Solver s) {
        //      0
        //     / \
        //   -1   1
        //   /
        // -1
        TreeNode root = n(0, n(-1, n(-1), null), n(1));

        assertArrayEquals(new int[] { -1 }, s.findMode(root));
    }

    @SolverTest
    void shouldReturnAllModesInSortedOrderFromInorderTraversal(SolutionVariants.Solver s) {
        //         4
        //       /   \
        //      2     6
        //     / \   / \
        //    1   2 6   7
        TreeNode root = n(4, n(2, n(1), n(2)), n(6, n(6), n(7)));

        assertArrayEquals(new int[] { 2, 6 }, s.findMode(root));
    }

    @SolverTest
    void shouldHandleLargerFrequencyGap(SolutionVariants.Solver s) {
        //          5
        //        /   \
        //       3     7
        //      / \   / \
        //     3   4 7   8
        //    /
        //   3
        TreeNode root = n(5, n(3, n(3, n(3), null), n(4)), n(7, n(7), n(8)));

        assertArrayEquals(new int[] { 3 }, s.findMode(root));
    }

    private static TreeNode n(int val) {
        return new TreeNode(val);
    }

    private static TreeNode n(int val, TreeNode left, TreeNode right) {
        TreeNode node = new TreeNode(val);
        node.left = left;
        node.right = right;
        return node;
    }
}
