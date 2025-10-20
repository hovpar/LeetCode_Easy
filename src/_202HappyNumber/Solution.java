package _202HappyNumber;

class Solution {

    boolean isHappy(int n) {
//        var length = (int) Math.log10(n) + 1;
//
//        var squareSum = 0;
//
//        for (int i = 0; i < length; i++) {
//            squareSum += (n % 10) * (n % 10);
//            n /= 10;
//        }
//        if (squareSum == 1 || squareSum == 7) {
//            return true;
//        } else if (squareSum < 10) {
//            return false;
//        } else {
//            return isHappy(squareSum);
//        }
        // 7 -> 49 -> 97 -> 130 -> 10 -> 1
        if (n == 1 || n == 7) {
            return true;
            // 2 -> 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4 (cycle)
        } else if (n < 10) {
            return false;
        } else {
            var sum = 0;

            while (n > 0) {
                var digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            return isHappy(sum);
        }
    }

}
