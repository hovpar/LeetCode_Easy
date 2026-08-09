package p027_remove_element;

class SolutionVariants {

    interface Solver {
        int removeElement(int[] nums, int val);
    }

    //preserves the relative order of retained elements
    static class StableCompactionSolution implements Solver {
        @Override
        public int removeElement(int[] nums, int val) {
            int k = 0;

            for (int num : nums) {
                if (num != val) {
                    nums[k++] = num;
                }
            }

            return k;
        }
    }

    //may change their order to reduce unnecessary copying
    static class SwapWithEndSolution implements Solver {
        @Override
        public int removeElement(int[] nums, int val) {
            var start = 0;
            var end = nums.length - 1;

            while (start <= end) {
                if (nums[end] == val) {
                    end--;
                    continue;
                }
                if (nums[start] == val) {
                    nums[start] = nums[end];
                    end--;
                }
                start++;

            }
            return start;
        }
    }

}
