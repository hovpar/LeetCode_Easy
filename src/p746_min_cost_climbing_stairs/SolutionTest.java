package p746_min_cost_climbing_stairs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @ParameterizedTest(name = "{0}")
    @MethodSource("solvers")
    @interface TestEachSolver {
    }

    static Stream<Arguments> solvers() {
        return Stream.of(
                arguments(Named.of("naive recursion solver", new SolutionVariants.NaiveRecursionSolver())),
                arguments(Named.of("dp array solver", new SolutionVariants.DPArraySolver())),
                arguments(Named.of("two variables solver", new SolutionVariants.TwoVariablesSolver())));
    }

    @TestEachSolver
    void shouldHandleThreeStairs(SolutionVariants.Solver solver) {
        assertEquals(15, solver.minCostClimbingStairs(new int[] { 10, 15, 20 }));
    }

    @TestEachSolver
    void shouldHandleMultipleStairs(SolutionVariants.Solver solver) {
        assertEquals(6, solver.minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
    }

    @TestEachSolver
    void shouldHandleTwoStairs(SolutionVariants.Solver solver) {
        assertEquals(1, solver.minCostClimbingStairs(new int[] { 1, 2 }));
    }

    @TestEachSolver
    void shouldChooseCheaperStartingStair(SolutionVariants.Solver solver) {
        assertEquals(5, solver.minCostClimbingStairs(new int[] { 5, 10 }));
    }

    @TestEachSolver
    void shouldHandleEqualCosts(SolutionVariants.Solver solver) {
        assertEquals(10, solver.minCostClimbingStairs(new int[] { 5, 5, 5, 5 }));
    }

    @TestEachSolver
    void shouldHandleAllZeroCosts(SolutionVariants.Solver solver) {
        assertEquals(0, solver.minCostClimbingStairs(new int[] { 0, 0, 0, 0 }));
    }

    @TestEachSolver
    void shouldHandleIncreasingCosts(SolutionVariants.Solver solver) {
        assertEquals(6, solver.minCostClimbingStairs(new int[] { 1, 2, 3, 4, 5 }));
    }

    @TestEachSolver
    void shouldHandleDecreasingCosts(SolutionVariants.Solver solver) {
        assertEquals(6, solver.minCostClimbingStairs(new int[] { 5, 4, 3, 2, 1 }));
    }

    @TestEachSolver
    void shouldHandleAlternatingCosts(SolutionVariants.Solver solver) {
        assertEquals(3, solver.minCostClimbingStairs(new int[] { 1, 100, 1, 100, 1, 100 }));
    }

    @TestEachSolver
    void shouldHandleLargeCosts(SolutionVariants.Solver solver) {
        assertEquals(1_000_000, solver.minCostClimbingStairs(new int[] { 1_000_000, 1_000_000, 1_000_000 }));
    }

}
