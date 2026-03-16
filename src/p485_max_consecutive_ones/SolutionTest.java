package p485_max_consecutive_ones;

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
    @ParameterizedTest
    @MethodSource("solvers")
    @interface SolverTest {
    }

    static Stream<SolutionVariants.Solver> solvers() {
        return Stream.of(new SolutionVariants.RunningCountSolver(), new SolutionVariants.EndOfStreakSolver(),
                new SolutionVariants.TwoPointerSolver());
    }

    @SolverTest
    void shouldReturnMaxRunWhenOnesAppearInMiddle(SolutionVariants.Solver solver) {
        int[] arr = { 1, 1, 0, 1, 1, 1 };
        assertEquals(3, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldReturnLongestRunWhenSeparatedByZeros(SolutionVariants.Solver solver) {
        int[] arr = { 1, 0, 1, 1, 0, 1 };
        assertEquals(2, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldReturnZeroWhenAllZeros(SolutionVariants.Solver solver) {
        int[] arr = { 0, 0, 0 };
        assertEquals(0, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldReturnArrayLengthForAllOnes(SolutionVariants.Solver solver) {
        int[] arr = { 1, 1, 1, 1, 1 };
        assertEquals(5, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldReturnOneForSingleOne(SolutionVariants.Solver solver) {
        int[] arr = { 1 };
        assertEquals(1, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldReturnZeroForSingleZero(SolutionVariants.Solver solver) {
        int[] arr = { 0 };
        assertEquals(0, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldHandleLongestRunAtBeginning(SolutionVariants.Solver solver) {
        int[] arr = { 1, 1, 1, 0, 0, 1 };
        assertEquals(3, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldHandleLongestRunAtEnd(SolutionVariants.Solver solver) {
        int[] arr = { 0, 1, 0, 1, 1, 1 };
        assertEquals(3, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldHandleAlternatingValues(SolutionVariants.Solver solver) {
        int[] arr = { 1, 0, 1, 0, 1, 0, 1 };
        assertEquals(1, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldHandleMultipleEqualLongestRuns(SolutionVariants.Solver solver) {
        int[] arr = { 1, 1, 0, 1, 1, 0, 1, 1 };
        assertEquals(2, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldHandleZeroBetweenLongRuns(SolutionVariants.Solver solver) {
        int[] arr = { 1, 1, 1, 1, 0, 1, 1, 1 };
        assertEquals(4, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldHandleManyTrailingZeros(SolutionVariants.Solver solver) {
        int[] arr = { 1, 1, 1, 0, 0, 0, 0 };
        assertEquals(3, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldHandleManyLeadingZeros(SolutionVariants.Solver solver) {
        int[] arr = { 0, 0, 0, 1, 1 };
        assertEquals(2, solver.findMaxConsecutiveOnes(arr));
    }

    @SolverTest
    void shouldReturnZeroWhenNoOnesExist(SolutionVariants.Solver solver) {
        int[] arr = { 0, 0, 0, 0, 0, 0 };
        assertEquals(0, solver.findMaxConsecutiveOnes(arr));
    }
}
