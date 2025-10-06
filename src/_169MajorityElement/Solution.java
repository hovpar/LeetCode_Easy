package _169MajorityElement;

import java.util.Arrays;

class Solution {

    // Moore Voting Algorithm
//    public int majorityElement(int[] nums) {
//        int candidate = 0, count = 0;
//
//        for (int num : nums) {
//            if (count == 0) {
//                candidate = num;
//            }
//
//            if (num == candidate) {
//                count++;
//            } else {
//                count--;
//            }
//        }
//
//        return candidate;
//    }

    // Approach with sorting the array
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
