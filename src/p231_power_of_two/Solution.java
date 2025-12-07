package p231_power_of_two;

class Solution {
    public boolean isPowerOfTwo(int n) {

        return n > 0 & ((n & (n - 1)) == 0);

    }

    // Iterative approach (Note: it doesn't pass testMaxIntAndNearMax())
//    public boolean isPowerOfTwo(int n) {
//        var x = 1;
//        while (x < n) {
//            x = x * 2;
//        }
//        return x == n;
//    }

}
