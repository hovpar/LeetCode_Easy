package p485_max_consecutive_ones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    static Stream<SolutionVariants.Solver> solvers() {
        return Stream.of(new SolutionVariants.RunningCountSolver(), new SolutionVariants.EndOfStreakSolver(),
                new SolutionVariants.TwoPointerSolver());
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldReturnMaxRunWhenOnesAppearInMiddle(SolutionVariants.Solver solver) {
        int[] arr = { 1, 1, 0, 1, 1, 1 };
        assertEquals(3, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldReturnLongestRunWhenSeparatedByZeros(SolutionVariants.Solver solver) {
        int[] arr = { 1, 0, 1, 1, 0, 1 };
        assertEquals(2, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldReturnZeroWhenAllZeros(SolutionVariants.Solver solver) {
        int[] arr = { 0, 0, 0 };
        assertEquals(0, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldReturnArrayLengthForAllOnes(SolutionVariants.Solver solver) {
        int[] arr = { 1, 1, 1, 1, 1 };
        assertEquals(5, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldReturnOneForSingleOne(SolutionVariants.Solver solver) {
        int[] arr = { 1 };
        assertEquals(1, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldReturnZeroForSingleZero(SolutionVariants.Solver solver) {
        int[] arr = { 0 };
        assertEquals(0, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldHandleLongestRunAtBeginning(SolutionVariants.Solver solver) {
        int[] arr = { 1, 1, 1, 0, 0, 1 };
        assertEquals(3, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldHandleLongestRunAtEnd(SolutionVariants.Solver solver) {
        int[] arr = { 0, 1, 0, 1, 1, 1 };
        assertEquals(3, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldHandleAlternatingValues(SolutionVariants.Solver solver) {
        int[] arr = { 1, 0, 1, 0, 1, 0, 1 };
        assertEquals(1, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldHandleMultipleEqualLongestRuns(SolutionVariants.Solver solver) {
        int[] arr = { 1, 1, 0, 1, 1, 0, 1, 1 };
        assertEquals(2, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldHandleZeroBetweenLongRuns(SolutionVariants.Solver solver) {
        int[] arr = { 1, 1, 1, 1, 0, 1, 1, 1 };
        assertEquals(4, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldHandleManyTrailingZeros(SolutionVariants.Solver solver) {
        int[] arr = { 1, 1, 1, 0, 0, 0, 0 };
        assertEquals(3, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldHandleManyLeadingZeros(SolutionVariants.Solver solver) {
        int[] arr = { 0, 0, 0, 1, 1 };
        assertEquals(2, solver.findMaxConsecutiveOnes(arr));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void shouldReturnZeroWhenNoOnesExist(SolutionVariants.Solver solver) {
        int[] arr = { 0, 0, 0, 0, 0, 0 };
        assertEquals(0, solver.findMaxConsecutiveOnes(arr));
    }
}
