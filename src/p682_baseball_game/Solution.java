package p682_baseball_game;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int calPoints(String[] operations) {
        List<Integer> scores = new ArrayList<>();

        for (String op : operations) {
            if (op.equals("+")) {
                scores.add(scores.get(scores.size() - 2) + scores.get(scores.size() - 1));
            } else if (op.equals("D")) {
                scores.add(scores.get(scores.size() - 1) * 2);
            } else if (op.equals("C")) {
                scores.removeLast();
            } else {
                scores.add(Integer.valueOf(op));
            }
        }

        var sum = 0;
        for (int record : scores) {
            sum += record;
        }
        return sum;
    }
}
