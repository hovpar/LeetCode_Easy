package p121_best_time_to_buy_and_sell_stock;

import java.util.Arrays;

class SolutionVariants {

    interface Solver {
        int maxProfit(int[] prices);
    }
    // Brute force, O (n^2)
    // Time Limit Exceeded 203 / 212 testcases passed

    static class BrutForceSolver implements Solver {
        public int maxProfit(int[] prices) {
            var size = prices.length;
            if (size < 2) {
                return 0;
            }

            var bestResults = new int[size - 1];

            for (int i = 0; i < size - 1; i++) {
                var cur = 0;
                for (int j = i + 1; j < size; j++) {
                    if (prices[j] - prices[i] > cur) {
                        cur = prices[j] - prices[i];
                    }
                }
                bestResults[i] = cur;
            }

            return Arrays.stream(bestResults).max().getAsInt();
        }
    }

    // better approach, O(n)
    static class OnePassMinPriceSolver implements Solver {
        public int maxProfit(int[] prices) {
            var min = Integer.MAX_VALUE; // min = 2^31-1
            int maxProfit = 0;

            for (int value : prices) {
                if (value < min) {
                    min = value;
                }

                var currentProfit = value - min;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }

            return maxProfit;
        }
    }

}
