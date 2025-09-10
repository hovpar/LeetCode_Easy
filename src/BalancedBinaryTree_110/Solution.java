package BalancedBinaryTree_110;

class Solution {

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		} else if (Math.abs(height(root.left) - height(root.right)) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int lHeight = height(root.left);
			int rHeight = height(root.right);

			return 1 + Math.max(lHeight, rHeight);
		}

	}
}
