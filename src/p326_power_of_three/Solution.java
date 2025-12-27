package p326_power_of_three;

class Solution {
//    boolean isPowerOfThree(int n) {
//        if (n < 1) {
//            return false;
//        }
//
//        while (n > 1 && n % 3 == 0) {
//            n /= 3;
//        }
//        return n == 1;
//
//    }

    // mathematical approach, time O(1)
    boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0; // Is n a positive divisor of the largest 3-power in int?”
    }

}
