package p501_find_mode_in_binary_search_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionVariants {

    interface Solver {
        int[] findMode(TreeNode root);
    }

    static class InorderTraversalSolver implements Solver {
        private int count = 0;
        private int maxCount = 0;
        private Integer prev = null;

        @Override
        public int[] findMode(TreeNode root) {
            if (root == null) {
                return new int[0];
            }

            List<Integer> modes = new ArrayList<>();
            traverseInorder(root, modes);

            int[] ans = new int[modes.size()];
            for (int i = 0; i < modes.size(); i++) {
                ans[i] = modes.get(i);
            }
            return ans;
        }

        private void traverseInorder(TreeNode root, List<Integer> modes) {
            if (root == null) {
                return;
            }

            traverseInorder(root.left, modes);

            if (prev != null && prev == root.val) {
                count++;
            } else {
                count = 1;
            }

            if (count > maxCount) {
                maxCount = count;
                modes.clear();
                modes.add(root.val);
            } else if (count == maxCount) {
                modes.add(root.val);
            }
            prev = root.val;

            traverseInorder(root.right, modes);
        }
    }

    static class HashMapFrequencySolver implements Solver {

        @Override
        public int[] findMode(TreeNode root) {
            if (root == null) {
                return new int[0];
            }

            Map<Integer, Integer> freq = new HashMap<>();
            dfs(root, freq);

            int max = 0;
            for (int count : freq.values()) {
                max = Math.max(max, count);
            }

            List<Integer> modes = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == max) {
                    modes.add(entry.getKey());
                }
            }

            return modes.stream().mapToInt(i -> i).toArray();
        }

        private void dfs(TreeNode node, Map<Integer, Integer> freq) {
            if (node == null) {
                return;
            }

            freq.put(node.val, freq.getOrDefault(node.val, 0) + 1);
            dfs(node.left, freq);
            dfs(node.right, freq);
        }

    }

}
