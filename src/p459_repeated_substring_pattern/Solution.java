package p459_repeated_substring_pattern;

class Solution {
//    boolean repeatedSubstringPattern(String s) {
//
//        var n = s.length();
//
//        for (int l = n / 2; l >= 1; l--) {
//            if (n % l == 0) {
//                var pattern = s.substring(0, l);
//                var times = n / l;
//                var newStr = pattern.repeat(times);
//
//                if (s.equals(newStr)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }

    // Concatenation trick
    boolean repeatedSubstringPattern(String s) {

        return ((s + s).substring(1, 2 * s.length() - 1)).contains(s);

    }
}
