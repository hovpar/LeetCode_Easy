package p643_maximum_average_subarray_i;

class SolutionVariants {

    interface Solver {
        double findMaxAverage(int[] nums, int k);
    }

    //Recalculates the sum of almost the same elements for every window.
    //Time: O((n - k) × k) -> worst case O(n × k),  Space: O(1)
    //Doesn't pass the LeetCode's test with very large array, when k=11149 -> Time Limit Exceeded
    static class BruteForceSolver implements Solver {
        @Override
        public double findMaxAverage(int[] nums, int k) {

            double maxAverage = Integer.MIN_VALUE;

            for (int i = 0; i <= nums.length - k; i++) {
                var sum = 0.0;
                for (int j = i; j < k + i; j++) {
                    sum += nums[j];
                }
                var actual = sum / k;
                if (actual > maxAverage) {
                    maxAverage = actual;
                }
            }
            return maxAverage;
        }
    }

    // When the window moves one position, remove the element leaving the window and add the new element entering it
    static class SlidingWindowSolver implements Solver {
        @Override
        public double findMaxAverage(int[] nums, int k) {
            long windowSum = 0;

            for (int i = 0; i < k; i++) {
                windowSum += nums[i];
            }

            long maxSum = windowSum;

            for (int i = k; i < nums.length; i++) {
                windowSum += nums[i];
                windowSum -= nums[i - k];

                maxSum = Math.max(maxSum, windowSum);
            }

            return (double) maxSum / k;
        }
    }

}
