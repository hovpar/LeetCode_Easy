package p671_second_minimum_node_in_a_bin_tree;

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        //the problem guarantees that a node has either 0 or 2 children
        if (root.left == null) {
            return -1;
        }

        int left = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val;

        int right = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;

        if (left == -1) {
            return right;
        }

        if (right == -1) {
            return left;
        }

        return Math.min(left, right);
    }

}
