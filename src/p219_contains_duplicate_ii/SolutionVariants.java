package p219_contains_duplicate_ii;

import java.util.HashSet;

class SolutionVariants {

    interface Solver {
        boolean containsNearbyDuplicate(int[] nums, int k);
    }

    // time: O(n*k), space: O(1)
    static class BruteForceSolver implements Solver {
        @Override
        public boolean containsNearbyDuplicate(int[] nums, int k) {

            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    static class HashSetSolver implements Solver {
        @Override
        public boolean containsNearbyDuplicate(int[] nums, int k) {

            var seen = new HashSet<Integer>();

            for (int i = 0; i < nums.length; i++) {
                if (i > k) {
                    // Remove the element that is now outside the k range
                    seen.remove(nums[i - k - 1]);
                }
                // Try to add the current element. If it fails, a duplicate exists.
                if (!seen.add(nums[i])) {
                    return true;
                }

            }
            return false;
        }

    }
}
