package p653_two_sum_iv_input_is_a_bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class SolutionVariants {

    interface Solver {
        boolean findTarget(TreeNode root, int k);
    }

    static class HashSetSolver implements Solver {
        @Override
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> values = new HashSet<>();
            return dfs(root, k, values);
        }

        private boolean dfs(TreeNode root, int k, Set<Integer> values) {
            if (root == null) {
                return false;
            }

            if (values.contains(k - root.val)) {
                return true;
            }

            values.add(root.val);

            return dfs(root.left, k, values) || dfs(root.right, k, values);
        }
    }

    static class TwoPointerSolver implements Solver {
        @Override
        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }

            Deque<TreeNode> ascending = new ArrayDeque<>();
            Deque<TreeNode> descending = new ArrayDeque<>();

            pushLeft(root, ascending);
            pushRight(root, descending);

            TreeNode left = nextAscending(ascending);
            TreeNode right = nextDescending(descending);

            while (left != null && right != null && left != right) {
                int sum = left.val + right.val;

                if (sum == k) {
                    return true;
                }

                if (sum < k) {
                    left = nextAscending(ascending);
                } else {
                    right = nextDescending(descending);
                }
            }

            return false;
        }

        private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        private void pushRight(TreeNode node, Deque<TreeNode> stack) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
        }

        private TreeNode nextAscending(Deque<TreeNode> stack) {
            if (stack.isEmpty()) {
                return null;
            }

            TreeNode node = stack.pop();
            pushLeft(node.right, stack);

            return node;
        }

        private TreeNode nextDescending(Deque<TreeNode> stack) {
            if (stack.isEmpty()) {
                return null;
            }

            TreeNode node = stack.pop();
            pushRight(node.left, stack);

            return node;
        }
    }

}
