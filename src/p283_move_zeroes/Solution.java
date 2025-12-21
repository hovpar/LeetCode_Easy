package p283_move_zeroes;

class Solution {
    void moveZeroes(int[] nums) {
        int index = 0; // Point to the next non-zero element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap current element with the element at index
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;   // Move to the next index for placing non-zero
            }
        }
    }
}
