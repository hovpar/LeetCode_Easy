package p263_ugly_number;

class Solution {
    // iterative approach
//    public boolean isUgly(int n) {
//        if (n < 1) {
//            return false;
//        }
//        final int[] factors = { 2, 3, 5 };
//        for (int f : factors) {
//            while (n % f == 0) {
//                n /= f;
//            }
//        }
//        return n == 1;
//    }
    // or
//    boolean isUgly(int n) {
//        if (n <= 0) return false;
//
//        for (int factor : new int[]{2, 3, 5}) {
//            while (n % factor == 0) {
//                n /= factor;
//            }
//        }
//        return n == 1;
//    }

    // recursive approach O(log n)
    boolean isUgly(int n) {
        if (n < 1) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n % 2 == 0) {
            return isUgly(n / 2);
        } else if (n % 3 == 0) {
            return isUgly(n / 3);
        } else if (n % 5 == 0) {
            return isUgly(n / 5);
        } else {
            return false;
        }
    }
}
