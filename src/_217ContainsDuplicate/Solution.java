package _217ContainsDuplicate;

import java.util.HashSet;

class Solution {
    // Brute force - fails timeout test!
//    public boolean containsDuplicate(int[] nums) {
//
//        var result = false;
//        for (int i = 0; i < nums.length - 1 && !result; i++) {
//            for (int j = i + 1; j < nums.length && !result; j++) {
//                if (nums[i] == nums[j]) {
//                    result = true;
//                }
//            }
//        }
//        return result;
//    }

    // Sort approach
//    public boolean containsDuplicate(int[] nums) {
//        int n = nums.length - 1;
//        var result = false;
//        Arrays.sort(nums);
//
//        for (int i = 0; i < n && !result; i++) {
//            if (nums[i] == nums[i + 1]) {
//                return true;
//            }
//
//        }
//        return false;
//    }

    // HashSet approach
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
