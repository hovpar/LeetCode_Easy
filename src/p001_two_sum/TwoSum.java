package p001_two_sum;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    // brute force
//    int[] twoSum(int[] nums, int target) {
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (var j = i + 1; j < nums.length; j++) {
//                if ((nums[i] + nums[j]) == target) {
//                    return new int[] { i, j };
//                }
//            }
//        }
//        return new int[] {};
//    }
    // Using HashMap O(n)
    int[] twoSum(int[] nums, int target) {
        // (value->index), O(1) lookup by key
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }
        return new int[] {};
    }

}
