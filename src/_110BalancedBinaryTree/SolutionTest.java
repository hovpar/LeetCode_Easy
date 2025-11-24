package _110BalancedBinaryTree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    Solution solution = new Solution();

    @Test
    void testBalancedTree() {
        Integer[] array = { 3, 9, 20, null, null, 15, 7 };
        TreeNode root = arrayToBinTree(array);
        assertTrue(solution.isBalanced(root));
    }

    @Test
    void testUnbalancedTree() {
        Integer[] array = { 1, 2, 2, 3, 3, null, null, 4, 4 };
        TreeNode root = arrayToBinTree(array);
        assertFalse(solution.isBalanced(root));
    }

    @Test
    void testEmptyTree() {
        Integer[] array = {};
        TreeNode root = arrayToBinTree(array);
        assertTrue(solution.isBalanced(root));
    }

}
