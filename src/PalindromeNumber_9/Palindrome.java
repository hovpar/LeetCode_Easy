package PalindromeNumber_9;

class Palindrome {
//    Given an integer x, return true if x is a palindrome, and false otherwise.
//
//            Example 1:
//
//            Input: x = 121
//            Output: true
//            Explanation: 121 reads as 121 from left to right and from right to left.
//            Example 2:
//
//            Input: x = -121
//            Output: false
//            Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//            Example 3:
//
//            Input: x = 10
//            Output: false
//            Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//            Constraints:
//
//            -231 <= x <= 231 - 1
//            Follow up: Could you solve it without converting the integer to a string?

    public boolean isPalindrome(int x) {
//        var isPalindrome = true;
//        var cd = countDigits(x);
//        var power = cd;
//
//        for (int i = 0; i < cd / 2 && isPalindrome; i++) {
//            int start = (int) (x / Math.pow(10, power - 1));
//            int end = x % 10;
//            if (start != end) {
//                isPalindrome = false;
//            }
//            x = (x % (int) Math.pow(10, power - 1) - end) / 10;
//            power = power - 2;
//        }
//
//        return isPalindrome;
//    }
//
//    public static int countDigits(int num) {
//        int count = 1;
//
//        while (num / 10 != 0) {
//            num = num / 10;
//            count++;
//        }
//        return count;
        int reverse = reverse(x);
        if(reverse==x) {
            return true;
        }else {
            return false;
        }

    }

    private int reverse(int num) {
        var rev = 0;
        while (num != 0) {
            var remainder = num % 10;
            rev = rev * 10 + remainder;
            num = num / 10;
        }
        return rev;
    }

}
