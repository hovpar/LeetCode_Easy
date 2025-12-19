package p009_palindrome_number;

class Palindrome {

//    boolean isPalindrome(int x) {
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
//    private int countDigits(int num) {
//        int count = 1;
//
//        while (num / 10 != 0) {
//            num = num / 10;
//            count++;
//        }
//        return count;

//}
    // Approach with the reverse of the integer
    boolean isPalindrome(int x) {
        int reverse = reverse(x);
        return reverse == x;

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
