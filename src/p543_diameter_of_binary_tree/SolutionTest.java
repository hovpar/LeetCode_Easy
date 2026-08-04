package p543_diameter_of_binary_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void emptyTreeHasDiameterZero() {
        assertEquals(0, solution.diameterOfBinaryTree(null));
    }

    @Test
    void singleNodeHasDiameterZero() {
        TreeNode root = new TreeNode(1);

        assertEquals(0, solution.diameterOfBinaryTree(root));
    }

    @Test
    void calculatesDiameterThroughRoot() {
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = node(1, node(2, node(4), node(5)), node(3));

        assertEquals(3, solution.diameterOfBinaryTree(root));
    }

    @Test
    void calculatesDiameterThatDoesNotPassThroughRoot() {
        //           1
        //          /
        //         2
        //        / \
        //       3   4
        //      /     \
        //     5       6
        TreeNode root = node(1, node(2, node(3, node(5), null), node(4, null, node(6))), null);

        assertEquals(4, solution.diameterOfBinaryTree(root));
    }

    @Test
    void calculatesDiameterOfSkewedTree() {
        // 1 -> 2 -> 3 -> 4
        TreeNode root = node(1, null, node(2, null, node(3, null, node(4))));

        assertEquals(3, solution.diameterOfBinaryTree(root));
    }

    @Test
    void supportsRepeatedCallsOnSameInstance() {
        TreeNode largeTree = node(1, node(2, node(4), node(5)), node(3));
        TreeNode singleNode = node(1);

        assertEquals(3, solution.diameterOfBinaryTree(largeTree));
        assertEquals(0, solution.diameterOfBinaryTree(singleNode));
    }

    private static TreeNode node(int value) {
        return new TreeNode(value);
    }

    private static TreeNode node(int value, TreeNode left, TreeNode right) {
        return new TreeNode(value, left, right);
    }
}
