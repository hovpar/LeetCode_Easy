package PathSum_112;

class Solution {

	boolean hasPathSum(TreeNode root, int targetSum) {
		//return pathSumDFS(root, targetSum);
		return dfs(root, 0, targetSum);
	}

	// use depth-first-search algorithm
	boolean pathSumDFS(TreeNode node, int remainingSum) {
		if (node == null) {
			return false;
		}
		remainingSum -= node.val;
		if (node.left == null && node.right == null && remainingSum == 0) {
			return true;
		}
		return pathSumDFS(node.left, remainingSum) || pathSumDFS(node.right, remainingSum);
	}

	// track the accumulated sum (currentSum) instead of subtracting a remaining sum
	boolean dfs(TreeNode node, int currentSum, int targetSum) {
		if (node == null) {
			return false;
		}

		currentSum += node.val;

		// If it's a leaf, check if the accumulated sum matches
		if (node.left == null && node.right == null) {
			return currentSum == targetSum;
		}

		return dfs(node.left, currentSum, targetSum) || dfs(node.right, currentSum, targetSum);
	}
}
