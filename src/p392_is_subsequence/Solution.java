package p392_is_subsequence;

class Solution {

    // Two pointer approach
    boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    // Note: If the follow-up requires many different s queries against the same t,
    // then preprocessing t (index lists + binary search per character) can be
    // better overall.

}
