package p617_merge_two_binary_trees;

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        return merge(root1, root2);

    }

    private TreeNode merge(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null) {
            return rightTree;
        } else if (rightTree == null) {
            return leftTree;
        } else {
            leftTree.val = leftTree.val + rightTree.val;

            leftTree.left = merge(leftTree.left, rightTree.left);
            leftTree.right = merge(leftTree.right, rightTree.right);

            return leftTree;
        }
    }
}
