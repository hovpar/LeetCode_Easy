package p283_move_zeroes;

class Solution {
    // Two-pointer with swaps approach
//    void moveZeroes(int[] nums) {
//        int index = 0; //Maintains a pointer to the next position for a non-zero
//        for (int i = 0; i < nums.length; i++) {
//            //Swap when a non-zero is found.
//            if (nums[i] != 0) {
//                int temp = nums[i];
//                nums[i] = nums[index];
//                nums[index] = temp;
//                index++;
//            }
//        }
//    }
    // Two-pass overwrite approach
    void moveZeroes(int[] nums) {
        int index = 0;

        for (int n : nums) {
            if (n != 0) {
                nums[index] = n;
                index++; // or just
                // nums[index++] = n;
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

}
