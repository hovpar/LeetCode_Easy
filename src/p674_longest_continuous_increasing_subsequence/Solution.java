package p674_longest_continuous_increasing_subsequence;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int longest = 0, current = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] < nums[i]) {
                current++;

            } else {

                current = 1;
            }
            longest = Math.max(current, longest);
        }

        return longest;
    }

    /**
     * Java's || operator uses short-circuit evaluation. If the left-hand condition
     * is true, Java doesn't evaluate the right-hand condition. When i == 0:
     * 
     * 1. Java evaluates i == 0, which is true.
     * 
     * 2. Because the first operand is true, the entire || expression must be true.
     * 
     * 3. Java skips `nums[i - 1] < nums[i]`, so `nums[-1]` is never accessed.
     */
}
