package p572_subtree_of_another_tree;

class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        if (subRoot == null) {
            return true;
        }

        if (isIdentical(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == t2;

        } else {
            return (t1.val == t2.val) && isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
        }

    }

}
