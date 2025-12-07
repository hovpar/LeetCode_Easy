package p222_count_complete_tree_nodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {
    // Complete-Tree creation from an array
    private TreeNode arrayToBinTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int n = arr.length;
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] == null) {
                return null; // defensive: but shouldn't happen for complete-tree input
            }
            nodes[i] = new TreeNode(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * i + 2;
            if (leftIdx < n) {
                nodes[i].left = nodes[leftIdx];
            }
            if (rightIdx < n) {
                nodes[i].right = nodes[rightIdx];
            }
        }

        return nodes[0];
    }

    Solution solution = new Solution();

    @Test
    void testCompleteMissingOneAtLastLevel() {
        // Last level: left-to-right filled but missing last rightmost node.
        // e.g. nodes = 6: levels: 1, 2, 3 -> array length 6
        Integer[] array = { 1, 2, 3, 4, 5, 6 }; // complete (LeetCode example)
        TreeNode root = arrayToBinTree(array);
        assertEquals(6, solution.countNodes(root));
    }

    @Test
    void testEmptyTree() {
        Integer[] array = {};
        TreeNode root = arrayToBinTree(array);

        assertEquals(0, solution.countNodes(root));
    }

    @Test
    void testSingleElement() {
        Integer[] array = { 1 };
        TreeNode root = arrayToBinTree(array);

        assertEquals(1, solution.countNodes(root));
    }

    @Test
    void testFullLevel() {
        Integer[] array = { 1, 2, 3 }; // complete and full for height=2
        TreeNode root = arrayToBinTree(array);
        assertEquals(3, solution.countNodes(root));
    }

    @Test
    void testCompleteFullFourLevels() {
        // full complete tree with 15 nodes
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        TreeNode root = arrayToBinTree(array);
        assertEquals(15, solution.countNodes(root));
    }

    @Test
    void testCompleteLastLevelPartiallyFilled() {
        // 14 nodes: last level missing rightmost node (index 14 missing)
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        TreeNode root = arrayToBinTree(array);
        assertEquals(14, solution.countNodes(root));
    }

}
