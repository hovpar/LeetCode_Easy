package p349_intersection_of_two_arrays;

import java.util.HashSet;
import java.util.Set;

class Solution {
    // HashSet approach, time O(n+m), space O(n + m)
    int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }

        Set<Integer> result = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n)) {
                result.add(n);
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for (int n : result) {
            arr[i++] = n;
        }
        return arr;

    }

}
