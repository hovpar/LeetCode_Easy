package p121_best_time_to_buy_and_sell_stock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void profitPossibleWithValleyAndPeak() {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        assertEquals(5, solution.maxProfit(prices));
    }

    @Test
    void noProfitWhenPricesOnlyDecrease() {
        int[] prices = { 7, 6, 4, 3, 1 };
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    void noProfitWithSingleDay() {
        int[] prices = { 1 };
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    void profitPossibleButNotFromFirstDay() {
        int[] prices = { 7, 4, 5, 3, 6, 1 };
        assertEquals(3, solution.maxProfit(prices));
    }

    @Test
    void noProfitWithEmptyPrices() {
        int[] prices = {};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    void profitWithMonotonicIncrease() {
        int[] prices = { 1, 2, 3, 4, 5 };
        assertEquals(4, solution.maxProfit(prices)); // buy at 1, sell at 5
    }

    @Test
    void constantPricesNoProfit() {
        int[] prices = { 5, 5, 5, 5 };
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    void profitWithLateValley() {
        int[] prices = { 10, 9, 8, 1, 7 };
        assertEquals(6, solution.maxProfit(prices)); // buy at 1, sell at 7
    }
}
