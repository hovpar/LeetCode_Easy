package p350_intersection_of_two_arrays_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    // Three pointer approach
//    int[] intersect(int[] nums1, int[] nums2) {
//        int i = 0, j = 0, k = 0;
//        int length1 = nums1.length, length2 = nums2.length;
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//
//        while (i < length1 && j < length2) {
//            if (nums1[i] < nums2[j]) {
//                i++;
//            } else if (nums1[i] > nums2[j]) {
//                j++;
//            } else {
//                nums1[k] = nums1[i]; // build result in-place
//                i++;
//                j++;
//                k++;
//            }
//        }
//        return Arrays.copyOfRange(nums1, 0, k);
//    }
    // HashMap approach
//  int[] intersect(int[] nums1, int[] nums2) {
//  if (nums1.length > nums2.length) {
//      return intersect(nums2, nums1); // ensure nums1 is smaller
//  }
//
//  Map<Integer, Integer> freq = new HashMap<>();
//  for (int x : nums1) {
//      freq.put(x, freq.getOrDefault(x, 0) + 1);
//  }
//
//  int[] tmp = new int[Math.min(nums1.length, nums2.length)];
//  int k = 0;
//
//  for (int y : nums2) {
//      Integer c = freq.get(y);
//      if (c != null && c > 0) {
//          tmp[k++] = y;
//          if (c == 1) {
//              freq.remove(y);
//          } else {
//              freq.put(y, c - 1);
//          }
//      }
//  }
//
//  return Arrays.copyOf(tmp, k);
//}

    int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums1) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int y : nums2) {
            Integer c = freq.get(y);
            if (c != null && c > 0) {
                result.add(y);
                freq.put(y, c - 1);
            }
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

}
