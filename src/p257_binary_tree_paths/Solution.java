package p257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        // Case 1: empty tree -> no paths
        if (root == null) {
            return paths;
        }

        // Case 2: leaf node -> the only path is the node's value
        if (root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
            return paths;
        }

        // Case 3: internal node -> collect paths from left and right

        // Get all paths from the left subtree and prepend the current value
        for (String path : binaryTreePaths(root.left)) {
            paths.add(root.val + "->" + path);
        }

        // Get all paths from the right subtree and prepend the current value
        for (String path : binaryTreePaths(root.right)) {
            paths.add(root.val + "->" + path);
        }

        return paths;
    }

}
