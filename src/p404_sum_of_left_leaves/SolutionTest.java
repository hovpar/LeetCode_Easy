package p404_sum_of_left_leaves;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private TreeNode arrayToBinTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length) {
            TreeNode current = queue.poll();
            if (current == null) break;

            // Left child
            if (i < array.length && array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    private final Solution s = new Solution();

    @Test
    void testExampleTree() {
        Integer[] array = { 3, 9, 20, null, null, 15, 7 };
        TreeNode tree = arrayToBinTree(array);
        assertEquals(24, s.sumOfLeftLeaves(tree)); // 9 + 15
    }

    @Test
    void testSingleNodeSumIsZero() {
        Integer[] array = { 1 };
        TreeNode tree = arrayToBinTree(array);
        assertEquals(0, s.sumOfLeftLeaves(tree));
    }

    @Test
    void testNullRootSumIsZero() {
        TreeNode tree = arrayToBinTree(null);
        assertEquals(0, s.sumOfLeftLeaves(tree));
    }

    @Test
    void testRootWithOnlyLeftLeaf() {
        Integer[] array = { 1, 2, null };
        TreeNode tree = arrayToBinTree(array);
        assertEquals(2, s.sumOfLeftLeaves(tree)); // left leaf is 2
    }

    @Test
    void testRootWithOnlyRightLeafNotCounted() {
        Integer[] array = { 1, null, 2 };
        TreeNode tree = arrayToBinTree(array);
        assertEquals(0, s.sumOfLeftLeaves(tree)); // right leaf must not count
    }

    @Test
    void testLeftChildIsNotLeafMustNotCount() {
        // left leaves: only 3 (2 is left but not a leaf)
        Integer[] array = { 1, 2, null, 3 };
        TreeNode tree = arrayToBinTree(array);
        assertEquals(3, s.sumOfLeftLeaves(tree));
    }

    @Test
    void testDeeperMixedLeaves() {
        // Tree:
        //        1
        //      /   \
        //     2     3
        //    / \     \
        //   4   5     6
        //      /
        //     7
        // Left leaves: 4 and 7 (5 is not leaf, 6 is right leaf)
        Integer[] array = { 1, 2, 3, 4, 5, null, 6, null, null, 7 };
        TreeNode tree = arrayToBinTree(array);
        assertEquals(11, s.sumOfLeftLeaves(tree)); // 4 + 7
    }

    @Test
    void testAllRightSkewedNoLeftLeaves() {
        // 1 ->R 2 ->R 3 ->R 4
        Integer[] array = { 1, null, 2, null, 3, null, 4 };
        TreeNode tree = arrayToBinTree(array);
        assertEquals(0, s.sumOfLeftLeaves(tree));
    }

    @Test
    void testAllLeftSkewedOnlyDeepestCounts() {
        // 1 ->L 2 ->L 3 ->L 4
        // left leaves: only 4
        Integer[] array = { 1, 2, null, 3, null, 4 };
        TreeNode tree = arrayToBinTree(array);
        assertEquals(4, s.sumOfLeftLeaves(tree));
    }

    @Test
    void testNegativeAndZeroValues() {
        //       0
        //      / \
        //    -2   3
        //    /
        //  -4
        // Left leaves: -4 (and -2 is not leaf)
        Integer[] array = { 0, -2, 3, -4 };
        TreeNode tree = arrayToBinTree(array);
        assertEquals(-4, s.sumOfLeftLeaves(tree));
    }

}
