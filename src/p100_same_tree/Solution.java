package p100_same_tree;

class Solution {

    boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q; // If both are null -> true, otherwise false
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
