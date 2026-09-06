package p217_contains_duplicate;

import java.util.Arrays;
import java.util.HashSet;

class SolutionVariants {

    interface Solver {
        boolean containsDuplicate(int[] nums);
    }

    // Fails Leetcode's timeout test!
    static class BruteForceSolver implements Solver {
        @Override
        public boolean containsDuplicate(int[] nums) {

            var result = false;
            for (int i = 0; i < nums.length - 1 && !result; i++) {
                for (int j = i + 1; j < nums.length && !result; j++) {
                    if (nums[i] == nums[j]) {
                        result = true;
                    }
                }
            }
            return result;
        }
    }

    static class ArraySortSolver implements Solver {
        @Override
        public boolean containsDuplicate(int[] nums) {
            int n = nums.length - 1;
            var result = false;
            Arrays.sort(nums);

            for (int i = 0; i < n && !result; i++) {
                if (nums[i] == nums[i + 1]) {
                    result = true;
                }

            }
            return result;
        }
    }

    static class HashSetSolver implements Solver {
        @Override
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> seen = new HashSet<>();

            for (int num : nums) {
                if (seen.contains(num)) {
                    return true;
                }
                seen.add(num);
            }
            return false;
        }
    }

}
