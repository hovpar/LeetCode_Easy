package p747_largest_number_at_least_twice_of_others;

class Solution {

    public int dominantIndex(int[] nums) {

        int index = 0, maxValue = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }

        for (int num : nums) {
            if (num > (maxValue / 2) && num != maxValue) {
                return -1;
            }
        }

        return index;
    }
}
