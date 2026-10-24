package p700_search_in_a_binary_search_tree;

import common.TreeNode;

class SolutionVariants {

    interface Solver {
        TreeNode searchBST(TreeNode root, int val);
    }

    static class RecursiveSolver implements Solver {
        @Override
        public TreeNode searchBST(TreeNode root, int val) {

            if (root == null || root.val == val) {
                return root;
            }

            if (root.val > val) {
                return searchBST(root.left, val);
            }
            return searchBST(root.right, val);

        }
    }

    static class IterativeSolver implements Solver {
        @Override
        public TreeNode searchBST(TreeNode root, int val) {
            while (root != null && root.val != val) {
                root = val < root.val ? root.left : root.right;
            }
            return root;
        }
    }

}
