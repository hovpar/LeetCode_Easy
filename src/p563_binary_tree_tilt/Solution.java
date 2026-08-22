package p563_binary_tree_tilt;

class Solution {

	public int findTilt(TreeNode root) {

		State state = new State();
		dfs(root, state);
		return state.sumOfTilts;

	}

	private int dfs(TreeNode node, State state) {
		if (node == null) {
			return 0;
		}

		int leftSum = dfs(node.left, state);
		int rightSum = dfs(node.right, state);

		state.sumOfTilts += Math.abs(leftSum - rightSum);

		return leftSum + rightSum + node.val;

	}

	private static class State {
		int sumOfTilts = 0;
	}
}
