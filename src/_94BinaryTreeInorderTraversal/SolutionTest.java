package _94BinaryTreeInorderTraversal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test1() {
		var three = new TreeNode(3);
		var two = new TreeNode(2, three, null);
		var root = new TreeNode(1, null, two);

		List<Integer> expected = List.of(1, 3, 2);
		assertEquals(expected, Solution.inorderTraversal(root));
	}

	@Test
	void test2() {
		var four = new TreeNode(4);
		var six = new TreeNode(6);
		var seven = new TreeNode(7, null, new TreeNode(9));
		var five = new TreeNode(5, six, seven);
		var two = new TreeNode(2, four, five);
		var eight = new TreeNode(8);
		var three = new TreeNode(3, null, eight);
		var root = new TreeNode(1, two, three);

		List<Integer> expected = List.of(4, 2, 6, 5, 7, 9, 1, 3, 8);
		assertEquals(expected, Solution.inorderTraversal(root));
	}

	@Test
	void test3() {
		TreeNode root = null;

		List<Integer> expected = List.of();
		assertEquals(expected, Solution.inorderTraversal(root));
	}

	@Test
	void test4() {
		var root = new TreeNode(1);

		List<Integer> expected = List.of(1);
		assertEquals(expected, Solution.inorderTraversal(root));
	}

}
