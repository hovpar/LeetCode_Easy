package _222CountCompleteTreeNodes;

class Solution {
    // Order traversal O(n)
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        } else {
//            return 1 + countNodes(root.left) + countNodes(root.right);
//        }
//
//    }

    int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        if (leftDepth == rightDepth) {
            return (int) (Math.pow(2, leftDepth) - 1);
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        } else {
//            return 1 + leftDepth(root.left);
//        }
        // or calculate the depth iteratively
        int depth = 0;
        var current = root;
        while (current != null) {
            current = current.left;
            depth++;
        }
        return depth;
    }

    private int rightDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        } else {
//            return 1 + rightDepth(root.right);
//        }
        // or calculate the depth iteratively
        int depth = 0;
        var current = root;
        while (current != null) {
            current = current.right;
            depth++;
        }
        return depth;
    }

}
