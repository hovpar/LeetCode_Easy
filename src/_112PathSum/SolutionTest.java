package _112PathSum;

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
	void testTrue() {
		Integer[] array = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 };
		TreeNode root = arrayToBinTree(array);
		assertTrue(solution.hasPathSum(root, 22));
	}

	@Test
	void testFalse() {
		Integer[] array = { 1, 2, 3 };
		TreeNode root = arrayToBinTree(array);
		assertFalse(solution.hasPathSum(root, 5));
	}

	@Test
	void testEmpty() {
		TreeNode root = null;
		assertFalse(solution.hasPathSum(root, 0));
	}
}
