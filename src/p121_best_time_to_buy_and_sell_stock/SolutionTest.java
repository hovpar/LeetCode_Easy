package p121_best_time_to_buy_and_sell_stock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("solvers")
    @interface SolverTest {
    }

    static Stream<SolutionVariants.Solver> solvers() {
        return Stream.of(new SolutionVariants.BrutForceSolver(), new SolutionVariants.OnePassMinPriceSolver());
    }

    @SolverTest
    void profitPossibleWithValleyAndPeak(SolutionVariants.Solver s) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        assertEquals(5, s.maxProfit(prices));
    }

    @SolverTest
    void noProfitWhenPricesOnlyDecrease(SolutionVariants.Solver s) {
        int[] prices = { 7, 6, 4, 3, 1 };
        assertEquals(0, s.maxProfit(prices));
    }

    @SolverTest
    void noProfitWithSingleDay(SolutionVariants.Solver s) {
        int[] prices = { 1 };
        assertEquals(0, s.maxProfit(prices));
    }

    @SolverTest
    void profitPossibleButNotFromFirstDay(SolutionVariants.Solver s) {
        int[] prices = { 7, 4, 5, 3, 6, 1 };
        assertEquals(3, s.maxProfit(prices));
    }

    @SolverTest
    void noProfitWithEmptyPrices(SolutionVariants.Solver s) {
        int[] prices = {};
        assertEquals(0, s.maxProfit(prices));
    }

    @SolverTest
    void profitWithMonotonicIncrease(SolutionVariants.Solver s) {
        int[] prices = { 1, 2, 3, 4, 5 };
        assertEquals(4, s.maxProfit(prices)); // buy at 1, sell at 5
    }

    @SolverTest
    void constantPricesNoProfit(SolutionVariants.Solver s) {
        int[] prices = { 5, 5, 5, 5 };
        assertEquals(0, s.maxProfit(prices));
    }

    @SolverTest
    void profitWithLateValley(SolutionVariants.Solver s) {
        int[] prices = { 10, 9, 8, 1, 7 };
        assertEquals(6, s.maxProfit(prices)); // buy at 1, sell at 7
    }
}
