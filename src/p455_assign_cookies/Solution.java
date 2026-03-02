package p455_assign_cookies;

import java.util.Arrays;

class Solution {
    int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int satisfiedCount = 0;
        int cookieIndex = 0;
        while (cookieIndex < s.length && satisfiedCount < g.length) {
            if (s[cookieIndex] >= g[satisfiedCount]) {
                satisfiedCount++;
            }
            cookieIndex++;
        }
        return satisfiedCount;
    }

}
