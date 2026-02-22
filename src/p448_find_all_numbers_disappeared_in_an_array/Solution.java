package p448_find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Using extra memory
//    List<Integer> findDisappearedNumbers(int[] nums) {
//
//        var set = new HashSet<Integer>();
//        for (int num : nums) {
//            set.add(num);
//        }
//
//        var result = new ArrayList<Integer>();
//        for (int i = 1; i <= nums.length; i++) {
//            if (!set.contains(i)) {
//                result.add(i);
//            }
//
//        }
//        return result;
//    }
    // In-Place Approach (Without Using Set)
    List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

}
