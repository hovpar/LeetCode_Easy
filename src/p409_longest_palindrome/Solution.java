package p409_longest_palindrome;

class Solution {
    // HashMap approach
//    int longestPalindrome(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (char c : s.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//        var res = 0;
//        var isOdd = false;
//
//        for (int val : map.values()) {
//            if (val % 2 == 0) {
//                res += val;
//            } else {
//                res += val - 1;
//                isOdd = true;
//            }
//        }
//
//        return isOdd ? res + 1 : res;
//    }

    // Bitwise Parity Tracking
//    int longestPalindrome(String s) {
//        Set<Character> odd = new HashSet<>();
//
//        for (char c : s.toCharArray()) {
//            if (!odd.add(c)) {
//                odd.remove(c);
//            }
//        }
//
//        return odd.isEmpty() ? s.length() : s.length() - odd.size() + 1;
//    }

    // Fixed-Size Frequency Array (More Efficient)
    int longestPalindrome(String s) {
        int[] freq = new int[128]; // ASCII
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int res = 0;
        boolean odd = false;

        for (int count : freq) {
            res += (count / 2) * 2;
            if (count % 2 == 1) {
                odd = true;
            }
        }

        return odd ? res + 1 : res;
    }

}
