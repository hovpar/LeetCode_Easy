package p145_binary_tree_postorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

//    public List<Integer> postorderTraversal(TreeNode root) {
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
//
//            preorderTraversal(node.left, list);
//            preorderTraversal(node.right, list);
//            list.add(node.val);
//
//        }
//    }

    // Iterative solution
//    List<Integer> postorderTraversal(TreeNode root) {
//
//        List<Integer> list = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode current = root, lastVisited = null;
//
//        while (current != null || !stack.isEmpty()) {
//            if (current != null) {
//                stack.push(current);
//                current = current.left;
//            } else {
//                TreeNode peek = stack.peek();
//                if (peek.right != null && lastVisited != peek.right) {
//                    // go right if not yet processed
//                    current = peek.right;
//                } else {
//                    list.add(peek.val); // visit
//                    lastVisited = stack.pop();
//                }
//            }
//        }
//        return list;
//
//    }

    // more intuitive approach with reverse adding
    List<Integer> postorderTraversal(TreeNode root) {
        // CURRENT, RIGHT, LEFT addFirst(value)
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.addFirst(current.val); // O(1)

            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        return result;
    }

}
