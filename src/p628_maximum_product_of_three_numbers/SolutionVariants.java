package p628_maximum_product_of_three_numbers;

import java.util.Arrays;

class SolutionVariants {

    interface Solver {
        int maximumProduct(int[] nums);
    }

    static class SortingSolver implements Solver {
        // O(n log n)
        @Override
        public int maximumProduct(int[] nums) {

            Arrays.sort(nums);
            int length = nums.length;

            return Math
                    .max(nums[0] * nums[1] * nums[length - 1], nums[length - 3] * nums[length - 2] * nums[length - 1]);
        }
    }

    static class LineratScanSolver implements Solver {
        // O(n)
        // Enumerate each element once while tracking
        // the two smallest and three largest values.
        @Override
        public int maximumProduct(int[] nums) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;

            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int max3 = Integer.MIN_VALUE;

            for (int num : nums) {
                // Two smallest
                if (num <= min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num < min2) {
                    min2 = num;
                }

                // Three largest
                if (num >= max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                } else if (num >= max2) {
                    max3 = max2;
                    max2 = num;
                } else if (num > max3) {
                    max3 = num;
                }
            }

            return Math.max(min1 * min2 * max1, max1 * max2 * max3);
        }
    }

    static class BruteForceSolver implements Solver {
        // O(n^3)
        // LeetCode; Time Limit Exceeded!!!
        @Override
        public int maximumProduct(int[] nums) {
            int maxProduct = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        int candidate = nums[i] * nums[j] * nums[k];
                        if (candidate > maxProduct) {
                            maxProduct = candidate;
                        }
                    }
                }
            }
            return maxProduct;
        }
    }

}
