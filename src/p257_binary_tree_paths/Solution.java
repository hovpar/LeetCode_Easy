package p257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

class Solution {

    // DFS approach, not efficient, time O(n^2), space O(n^2)
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> paths = new ArrayList<>();
//
//        // Case 1: empty tree -> no paths
//        if (root == null) {
//            return paths;
//        }
//
//        // Case 2: leaf node -> the only path is the node's value
//        if (root.left == null && root.right == null) {
//            paths.add(String.valueOf(root.val));
//            return paths;
//        }
//
//        // Case 3: internal node -> collect paths from left and right
//
//        // Get all paths from the left subtree and prepend the current value
//        for (String path : binaryTreePaths(root.left)) {
//            paths.add(root.val + "->" + path);
//        }
//
//        // Get all paths from the right subtree and prepend the current value
//        for (String path : binaryTreePaths(root.right)) {
//            paths.add(root.val + "->" + path);
//        }
//
//        return paths;
//    }

//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> paths = new ArrayList<>();
//        dfs(root, "", paths);
//        return paths;
//    }
//
//    private void dfs(TreeNode node, String path, List<String> paths) {
//        if (node == null) {
//            return;
//        }
//
//        // Extend the current path with this node's value
//        String currentPath = path.isEmpty() ? String.valueOf(node.val) : path + "->" + node.val;
//
//        // Leaf node -> store completed path
//        if (node.left == null && node.right == null) {
//            paths.add(currentPath);
//            return;
//        }
//
//        // Recurse into subtrees
//        dfs(node.left, currentPath, paths);
//        dfs(node.right, currentPath, paths);
//    }
    // More Efficient Version (O(n) Using StringBuilder)
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, new StringBuilder(), result);
        return result;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> result) {
        if (node == null) {
            return;
        }

        int len = path.length();
        path.append(node.val);

        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            path.append("->");
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }

        path.setLength(len); // backtrack
    }

}
