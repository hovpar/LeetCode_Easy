package p506_relative_ranks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] answer = new String[n];
        int[] clone = score.clone();
        Arrays.sort(clone);

        Map<Integer, String> rank = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int value = clone[n - 1 - i];

            if (i == 0) {
                rank.put(value, "Gold Medal");
            } else if (i == 1) {
                rank.put(value, "Silver Medal");
            } else if (i == 2) {
                rank.put(value, "Bronze Medal");
            } else {
                rank.put(value, String.valueOf(i + 1));
            }
        }

        for (int i = 0; i < n; i++) {
            answer[i] = rank.get(score[i]);
        }

        return answer;
    }
}
