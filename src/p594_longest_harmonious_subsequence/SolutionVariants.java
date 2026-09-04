package p594_longest_harmonious_subsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionVariants {

    interface Solver {
        int findLHS(int[] nums);
    }

    static class CountingSolver implements Solver {
        //For every value, count how many elements are equal to it and how many equal it + 1:
        @Override
        public int findLHS(int[] nums) {
            var lhs = 0;

            for (int i = 0; i < nums.length; i++) {
                var count = 0;
                var hasNext = false;

                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == nums[i]) {
                        count++;
                    } else if (nums[j] == nums[i] + 1) {
                        count++;
                        hasNext = true;
                    }
                }

                if (hasNext) {
                    lhs = Math.max(lhs, count);
                }
            }

            return lhs;
        }

    }

    static class ArraySortSolver implements Solver {
        @Override
        public int findLHS(int[] nums) {

            Arrays.sort(nums);

            int left = 0, lhs = 0;

            for (int right = 0; right < nums.length; right++) {
                //move left until difference exceeds 1
                while (nums[right] - nums[left] > 1) {
                    left++;
                }
                if (nums[right] - nums[left] == 1) {
                    lhs = Math.max(lhs, right - left + 1);
                }
            }
            return lhs;
        }
    }

    static class HashMapSolver implements Solver {
        @Override
        public int findLHS(int[] nums) {
            Map<Integer, Integer> frequencies = new HashMap<>();
            // Count occurrences of every number.
            for (int num : nums) {
                if (frequencies.containsKey(num)) {
                    frequencies.put(num, frequencies.get(num) + 1);
                } else {
                    frequencies.put(num, 1);
                }
                //or just
                //frequencies.merge(num, 1, Integer::sum);

            }

            var lhs = 0;
            // Check every pair of consecutive values.
            for (var entry : frequencies.entrySet()) {
                var next = frequencies.get(entry.getKey() + 1);

                if (next != null) {
                    lhs = Math.max(lhs, entry.getValue() + next);
                }
            }

            return lhs;
        }
    }

}
