package p367_valid_perfect_square;

class Solution {
    // mathematical approach, O(n), Timeout
//    boolean isPerfectSquare(int num) {
//        int odd = 1, sum = 1;
//
//        while (sum <= num) {
//            if (sum == num) {
//                return true;
//            } else {
//                odd += 2;
//                sum += odd;
//            }
//        }
//        return false;
//
//    }
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int left = 1, right = num / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sq = mid * mid;
            if (sq == num) {
                return true;
            } else if (sq > num) {
                right = (int) (mid - 1);
            } else {
                left = (int) (mid + 1);
            }
        }
        return false;
    }
}
