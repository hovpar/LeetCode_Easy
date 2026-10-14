package p682_baseball_game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class SolutionVariants {

    interface Solver {
        int calPoints(String[] operations);
    }

    static class ArrayListSolver implements Solver {
        @Override
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

    static class StackSolver implements Solver {
        @Override
        public int calPoints(String[] operations) {
            Deque<Integer> scores = new ArrayDeque<>();
            int sum = 0;

            for (String op : operations) {
                if (op.equals("+")) {
                    int last = scores.removeLast();
                    int previous = scores.getLast();
                    int score = last + previous;

                    scores.addLast(last);
                    scores.addLast(score);
                    sum += score;
                } else if (op.equals("D")) {
                    int score = scores.getLast() * 2;
                    scores.addLast(score);
                    sum += score;
                } else if (op.equals("C")) {
                    sum -= scores.removeLast();
                } else {
                    int score = Integer.parseInt(op);
                    scores.addLast(score);
                    sum += score;
                }
            }

            return sum;
        }
    }

}
