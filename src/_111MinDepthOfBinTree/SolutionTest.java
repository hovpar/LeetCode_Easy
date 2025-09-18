package _111MinDepthOfBinTree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;


class SolutionTest {
	
    TreeNode arrayToBinTree(Integer[] array) {
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
	void balancedTreeWithTwoLevels() {
		Integer[]array = {3,9,20,null,null,15,7};
		TreeNode root = arrayToBinTree(array);
		assertEquals(2, solution.minDepth(root));
	}
	
	@Test
	void skewedRightTree() {
		Integer[]array = {2,null,3,null,4,null,5,null,6};
		TreeNode root = arrayToBinTree(array);
		assertEquals(5, solution.minDepth(root));
	}
	@Test
    void leftHeavyTree() {
        Integer[] array = {1, 2, null, 3};
        TreeNode root = arrayToBinTree(array);
        assertEquals(3, solution.minDepth(root));
    }

    @Test
    void fullBalancedTree() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = arrayToBinTree(array);
        assertEquals(3, solution.minDepth(root));
    }

    @Test
    void nullRoot() {
        Integer[] array = {};
        TreeNode root = arrayToBinTree(array);
        assertEquals(0, solution.minDepth(root));
    }
}
