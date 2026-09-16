package p637_average_of_levels_in_binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class SolutionVariants {

    interface Solver {
        List<Double> averageOfLevels(TreeNode root);
    }

    static class RecursiveSolver implements Solver {
        @Override
        public List<Double> averageOfLevels(TreeNode root) {

            ArrayList<ArrayList<Integer>> levels = new ArrayList<>();

            levelOrderRec(root, 0, levels);

            List<Double> res = new ArrayList<>();

            for (ArrayList<Integer> level : levels) {
                res.add(calculateAverage(level));
            }

            return res;

        }

        private void levelOrderRec(TreeNode root, int level, ArrayList<ArrayList<Integer>> levels) {
            if (root == null) {
                return;
            }
            if (levels.size() <= level) {
                levels.add(new ArrayList<>());
            }
            levels.get(level).add(root.val);

            levelOrderRec(root.left, level + 1, levels);
            levelOrderRec(root.right, level + 1, levels);
        }

        private Double calculateAverage(ArrayList<Integer> level) {
            double sum = 0.0;
            for (Integer val : level) {
                sum += val;
            }

            return sum / level.size();
        }
    }

    static class QueueSolver implements Solver {

        @Override
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                long sum = 0;

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();

                    sum += node.val;

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                result.add((double) sum / levelSize);
            }

            return result;
        }
    }

}
