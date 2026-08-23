package p563_binary_tree_tilt;

class Solution {

    public int findTilt(TreeNode root) {

        State state = new State();
        subtreeSum(root, state);
        return state.totalTilt;

    }

    private int subtreeSum(TreeNode node, State state) {
        if (node == null) {
            return 0;
        }

        int leftSum = subtreeSum(node.left, state);
        int rightSum = subtreeSum(node.right, state);

        state.totalTilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + node.val;

    }

    private static class State {
        int totalTilt = 0;
    }
}
