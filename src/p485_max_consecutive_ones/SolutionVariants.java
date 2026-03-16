package p485_max_consecutive_ones;

class SolutionVariants {

    interface Solver {
        int findMaxConsecutiveOnes(int[] nums);
    }

    // Time: O(n), Space: O(1)
    static class RunningCountSolver implements Solver {
        @Override
        public int findMaxConsecutiveOnes(int[] nums) {
            int currentStreak = 0;
            int longestStreak = 0;

            for (int num : nums) {
                if (num == 1) {
                    currentStreak++;
                    longestStreak = Math.max(longestStreak, currentStreak);
                } else {
                    currentStreak = 0;
                }
            }

            return longestStreak;
        }
    }

    // one assignment at the end of each streak
    // Cons: needs one final Math.max(...) after the loop
    static class EndOfStreakSolver implements Solver {
        @Override
        public int findMaxConsecutiveOnes(int[] nums) {
            int currentStreak = 0;
            int longestStreak = 0;

            for (int num : nums) {
                if (num == 1) {
                    currentStreak++;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 0;
                }
            }

            return Math.max(longestStreak, currentStreak);
        }
    }

    // Two-pointer approach (unnecessary for this problem)
    static class TwoPointerSolver implements Solver {
        @Override
        public int findMaxConsecutiveOnes(int[] nums) {
            int left = 0;
            int max = 0;

            for (int right = 0; right < nums.length; right++) {
                if (nums[right] == 0) {
                    left = right + 1;
                } else {
                    max = Math.max(max, right - left + 1);
                }
            }

            return max;
        }
    }
}
