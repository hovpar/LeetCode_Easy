package _226InvertBinTree;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        // recursive approach
//        if (root == null) {
//            return null;
//        } else {
//            var temp = root.left;
//            root.left = root.right;
//            root.right = temp;
//            invertTree(root.left);
//            invertTree(root.right);
        // or
//            TreeNode left = invertTree(root.left);
//            TreeNode right = invertTree(root.right);
//
//            root.left = right;
//            root.right = left;
//            return root;
//      }

        // iterative approach using queue
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // swap children
            final TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Add left and right of this node to the queue
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return root;

    }

}
