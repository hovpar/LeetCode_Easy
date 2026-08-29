package p144_binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class SolutionVariants {

    interface Solver {
        List<Integer> preorderTraversal(TreeNode root);
    }

    static class RecursiveSolver implements Solver {
        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            var list = new ArrayList<Integer>();
            preorderTraversal(root, list);
            return list;

        }

        private void preorderTraversal(TreeNode node, ArrayList<Integer> list) {
            if (node == null) {
                return;
            } else {
                list.add(node.val);
                preorderTraversal(node.left, list);
                preorderTraversal(node.right, list);

            }

        }
    }

    static class IterativeSolver implements Solver {
        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
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

}
