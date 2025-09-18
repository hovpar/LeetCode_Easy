package _104MaxDepthOfBinaryTree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaxDepthOfBinaryTreeTest {

	@Test
	void testEmpty() {

		assertEquals(0, new MaxDepthOfBinaryTree().maxDepth(null));
	}

	@Test
	void testSingleDepth() {
		var tree = new TreeNode(1);

		assertEquals(1, new MaxDepthOfBinaryTree().maxDepth(tree));
	}

	@Test
	void testTwoDepth() {
		var tree = new TreeNode(1, null, new TreeNode(2));

		assertEquals(2, new MaxDepthOfBinaryTree().maxDepth(tree));
	}

	@Test
	void testSeveralDepth() {
		var tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

		assertEquals(3, new MaxDepthOfBinaryTree().maxDepth(tree));
	}

	@Test
	void testLeftSkewedTree() {
		var tree = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), null);

		assertEquals(4, new MaxDepthOfBinaryTree().maxDepth(tree));
	}

	@Test
	void testRightSkewedTree() {
		var tree = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

		assertEquals(4, new MaxDepthOfBinaryTree().maxDepth(tree));
	}

	@Test
	void testBalancedTree() {
		var tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
				new TreeNode(3, new TreeNode(6), new TreeNode(7)));

		assertEquals(3, new MaxDepthOfBinaryTree().maxDepth(tree));
	}

	@Test
	void testUnbalancedTree() {
		var tree = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), new TreeNode(5));

		assertEquals(4, new MaxDepthOfBinaryTree().maxDepth(tree));
	}

}
