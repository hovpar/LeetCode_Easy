package PascalsTriangle_118;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        // first row
        result.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            var prevList = result.get(i - 1);
            List<Integer> currentList = new ArrayList<>();

            currentList.add(1); // first element is always 1

            for (int j = 1; j < i; j++) {
                currentList.add(prevList.get(j - 1) + prevList.get(j));
            }

            currentList.add(1); // last element is always 1

            result.add(currentList);
        }

        return result;
    }
}
