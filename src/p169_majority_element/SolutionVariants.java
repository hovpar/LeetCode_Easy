package p169_majority_element;

import java.util.Arrays;

class SolutionVariants {

    interface Solver {
        int majorityElement(int[] nums);
    }

    static class MooreVotingSolver implements Solver {
        // Boyer–Moore majority vote algorithm:
        @Override
        public int majorityElement(int[] nums) {
            int candidate = 0, count = 0;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }

                if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            return candidate;
        }
    }

    static class SortingSolver implements Solver {
        @Override
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

}
