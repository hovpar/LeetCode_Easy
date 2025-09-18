package _119PascalsTriangle2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // recursive approach O(n^2) space O(n)
    List<Integer> getRow(int rowIndex) {

        List<Integer> current = new ArrayList<>();

        current.add(1);

        if (rowIndex == 0) {
            return current;
        }
        var prev = getRow(rowIndex - 1);

        for (int i = 1; i < rowIndex; i++) {
            current.add(prev.get(i - 1) + prev.get(i));
        }
        current.add(1);
        return current;

    }

    // Approach using formula
//    List<Integer> getRow(int n) {
//
//        List<Integer> res = new ArrayList<>();
//
//        // nC0 = 1
//        int prev = 1;
//        res.add(prev);
//
//        for (int i = 1; i <= n; i++) {
//
//            // nCr = (nCr-1 * (n - r + 1))/r
//            int curr = (prev * (n - i + 1)) / i;
//            res.add(curr);
//            prev = curr;
//        }
//        return res;
//    }
}
