package p414_third_maximum_number;

class Solution {

    // Three-Pointer technique
//    int thirdMax(int[] nums) {
//        Integer max = null;
//        Integer max2 = null;
//        Integer max3 = null;
//
//        for (Integer n : nums) {
//            if (n.equals(max) || n.equals(max2) || n.equals(max3)) {
//                continue;
//            } else {
//                if (max == null || n > max) {
//                    max3 = max2;
//                    max2 = max;
//                    max = n;
//                } else if (max2 == null || n > max2) {
//                    max3 = max2;
//                    max2 = n;
//                } else if (max3 == null || n > max3) {
//                    max3 = n;
//                }
//            }
//        }
//
//        return max3 == null ? max : max3;
//
//    }
    // Initializing pointers as Long.MIN_VALUE is significantly more efficient.
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int n : nums) {
            if (n == first) {
                continue;
            }

            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else {
                if (n == second) {
                    continue;
                }

                if (n > second) {
                    third = second;
                    second = n;
                } else {
                    if (n == third) {
                        continue;
                    }

                    if (n > third) {
                        third = n;
                    }
                }
            }
        }

        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}
