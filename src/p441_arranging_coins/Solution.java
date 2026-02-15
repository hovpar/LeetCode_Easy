package p441_arranging_coins;

class Solution {

    // iterative approach
    int arrangeCoins(int n) {

        var k = 0;

        while (n >= 0) {
            k++;
            n = n - k;
        }

        return k - 1;
    }

    // binary search approach
//    int arrangeCoins(int n) {
//        long start = 0;
//        long end = n;
//
//        while (start <= end) {
//            long mid = start + (end - start) / 2;
//
//            long coinsUsed = mid * (mid + 1) / 2;
//
//            if (coinsUsed == n) {
//                return (int) mid;
//            } else if (coinsUsed < n) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        return (int) end;
//
//    }

    // using Quadratic Formula
//    int arrangeCoins(int n) {
//        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
//
//    }
}
