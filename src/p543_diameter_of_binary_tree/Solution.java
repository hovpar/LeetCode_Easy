package p543_diameter_of_binary_tree;

class Solution {
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        this.res = 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        var left = dfs(node.left);
        var right = dfs(node.right);

        this.res = Math.max(res, left + right);

        return 1 + Math.max(left, right);
    }
}
