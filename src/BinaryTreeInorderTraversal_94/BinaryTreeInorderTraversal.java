package BinaryTreeInorderTraversal_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeInorderTraversal {

//	static List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> list = new ArrayList<>();
//		inorderTraversal(root, list);
//		return list;
//
//	}
//
//	private static void inorderTraversal(TreeNode node, List<Integer> list) {
//		if (node == null) {
//			return;
//		}else {
//			inorderTraversal(node.left, list);
//			list.add(node.val);
//			inorderTraversal(node.right, list);			
//		}		
//	}
	
	//Iterative solution
	static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		var current = root;

		while (!stack.isEmpty() || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				list.add(current.val);
				current = current.right;
			}
		}
		return list;
	}
}
