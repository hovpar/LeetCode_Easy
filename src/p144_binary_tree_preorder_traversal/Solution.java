package p144_binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

//    List<Integer> preorderTraversal(TreeNode root) {
//        var list = new ArrayList<Integer>();
//        preorderTraversal(root, list);
//        return list;
//
//    }
//
//    private void preorderTraversal(TreeNode node, ArrayList<Integer> list) {
//        if (node == null) {
//            return;
//        } else {
//            list.add(node.val);
//            preorderTraversal(node.left, list);
//            preorderTraversal(node.right, list);
//
//        }
//
//    }

    // Iterative solution
    List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        var current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                result.add(current.val);
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }
        return result;
    }

}
