package p268_missing_number;

class SolutionVariants {

    interface Solver {
        int missingNumber(int[] nums);
    }

    static class SumDifferenceSolver implements Solver {
        @Override
        public int missingNumber(int[] nums) {
            var sum = 0;
            var expectedSum = nums.length * (nums.length + 1) / 2;
            for (int n : nums) {
                sum += n;
            }

            return expectedSum - sum;
        }
    }

    static class XORSolver implements Solver {
        @Override
        public int missingNumber(int[] nums) {
            int xor = nums.length;
            for (int i = 0; i < nums.length; i++) {
                xor ^= i ^ nums[i];
            }
            return xor;
        }
    }

}
