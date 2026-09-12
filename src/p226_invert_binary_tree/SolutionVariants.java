package p226_invert_binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;

class SolutionVariants {

    interface Solver {
        TreeNode invertTree(TreeNode root);
    }

    static class RecursiveSolver implements Solver {
        @Override
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            } else {
                var temp = root.left;
                root.left = root.right;
                root.right = temp;
                invertTree(root.left);
                invertTree(root.right);
                //or
                //TreeNode left = invertTree(root.left);
                //TreeNode right = invertTree(root.right);
                //
                //root.left = right;
                //root.right = left;
                return root;

            }
        }
    }

    static class IterativeSolver implements Solver {
        // iterative approach using queue
        @Override
        public TreeNode invertTree(TreeNode root) {

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

}
