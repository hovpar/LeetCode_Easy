package p303_range_sum_query_immutable;

class NumArray {

    interface NumArraySolver {
        int sumRange(int left, int right);
    }

    static class NaiveSolver implements NumArraySolver {
        private final int[] nums;

        NaiveSolver(int[] nums) {
            this.nums = nums;
        }

        @Override
        public int sumRange(int left, int right) {
            int sum = 0;

            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }

            return sum;
        }
    }

    /**
     * Create an array with "Accumulated amounts" (`PrefixSum`). For each number in
     * this array, record the sum of the prices from the beginning of the shelf up
     * to that number (inclusive). nums = [2, 4, 6, 8] prefix = [2, 6, 12, 20]
     */

    static class PrefixSumSolverBasic implements NumArraySolver {
        private final int[] prefix;

        PrefixSumSolverBasic(int[] nums) {
            prefix = new int[nums.length];

            //Prevents ArrayIndexOutOfBoundsException
            if (nums.length == 0) {
                return;
            }

            prefix[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefix[i] = prefix[i - 1] + nums[i];
            }
        }

        @Override
        public int sumRange(int left, int right) {
            if (left == 0) {
                return prefix[right];
            }
            int sum = prefix[right] - prefix[left - 1];
            return sum;
        }
    }

    /**
     * Prefix array with extra leading zero (cleaner sum logic) prefix = [0, 2, 6,
     * 12, 20]
     */

    static class PrefixSumSolver implements NumArraySolver {
        private final int[] prefix;

        PrefixSumSolver(int[] nums) {
            //Each element stores the sum of all numbers before its index
            prefix = new int[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        @Override
        public int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }

}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(left,right);
 */
