package _136SingleNumber;

class Solution {
    // inefficient O(n^2)
//    public int singleNumber(int[] nums) {
//
//        for (int i = 0; i < nums.length; i++) {
//            boolean found = false;
//
//            for (int j = 0; j < nums.length && !found; j++) {
//                if (i != j && nums[i] == nums[j]) {
//                    found = true;
//                }
//            }
//
//            if (!found) {
//                return nums[i]; // this one has no duplicate
//            }
//        }
//
//        // shouldn't reach here if input is valid
//        throw new IllegalArgumentException("No unique number found");
//
//    }
    // You can solve this with bitwise XOR:

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num; // XOR cancels out duplicates
        }
        return result;
    }
}
