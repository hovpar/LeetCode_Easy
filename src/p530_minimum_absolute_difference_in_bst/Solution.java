package p530_minimum_absolute_difference_in_bst;

class Solution {

    public int getMinimumDifference(TreeNode root) {
        State state = new State();
        inorder(root, state);
        return state.minDiff;
    }

    private void inorder(TreeNode node, State state) {
        if (node == null) {
            return;
        }

        inorder(node.left, state);

        if (state.prev != null) {
            state.minDiff = Math.min(state.minDiff, node.val - state.prev);
        }

        state.prev = node.val;

        inorder(node.right, state);
    }

    //You can either use class fields or create an additional class to modify the state.

    //You can also avoid the helper class using arrays:
    //public int getMinimumDifference(TreeNode root) {
    //  int[] minDiff = { Integer.MAX_VALUE };
    //  Integer[] prev = { null };

    //  inorder(root, prev, minDiff);

    //  return minDiff[0];
    //}
    private static class State {
        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;
    }
}
