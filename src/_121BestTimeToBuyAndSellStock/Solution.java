package _121BestTimeToBuyAndSellStock;

class Solution {
    // Brute force, O (n^2)
    // Time Limit Exceeded 203 / 212 testcases passed
//    public int maxProfit(int[] prices) {
//        var size = prices.length;
//        if (size < 2) {
//            return 0;
//        }
//
//        var bestResults = new int[size - 1];
//
//        for (int i = 0; i < size - 1; i++) {
//            var cur = 0;
//            for (int j = i + 1; j < size; j++) {
//                if (prices[j] - prices[i] > cur) {
//                    cur = prices[j] - prices[i];
//                }
//            }
//            bestResults[i] = cur;
//        }
//
//        return Arrays.stream(bestResults).max().getAsInt();
//    }

    // better approach, O(n)

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
