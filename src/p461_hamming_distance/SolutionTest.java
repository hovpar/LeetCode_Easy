package p461_hamming_distance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class SolutionTest {

    static Stream<SolutionVariants.Solver> solvers() {
        return Stream.of(new SolutionVariants.BitByBitShiftSolver(), new SolutionVariants.XorBitCountShiftSolver(),
                new SolutionVariants.KernighanBitCountSolver());
    }

    @Test
    void returnsTwoForExampleCase(SolutionVariants.Solver solver) {
        assertEquals(2, solver.hammingDistance(4, 1));   // 100 vs 001
    }

    @Test
    void returnsOneForSingleBitDifference(SolutionVariants.Solver solver) {
        assertEquals(1, solver.hammingDistance(3, 1));   // 011 vs 001
    }

    @Test
    void returnsZeroForIdenticalNumbers(SolutionVariants.Solver solver) {
        assertEquals(0, solver.hammingDistance(7, 7));
    }

    @Test
    void returnsZeroForBothZero(SolutionVariants.Solver solver) {
        assertEquals(0, solver.hammingDistance(0, 0));
    }

    @Test
    void returnsOneWhenOneIsZero(SolutionVariants.Solver solver) {
        assertEquals(1, solver.hammingDistance(0, 1));
    }

    @Test
    void returnsThirtyOneForMaxIntAndZero(SolutionVariants.Solver solver) {
        assertEquals(31, solver.hammingDistance(Integer.MAX_VALUE, 0));
    }

    @Test
    void returnsThirtyTwoForMinusOneAndZero(SolutionVariants.Solver solver) {
        assertEquals(32, solver.hammingDistance(-1, 0));
    }

    @Test
    void returnsOneForMinValueAndZero(SolutionVariants.Solver solver) {
        assertEquals(1, solver.hammingDistance(Integer.MIN_VALUE, 0));
    }

    @Test
    void handlesNegativeNumbersCorrectly(SolutionVariants.Solver solver) {
        assertEquals(31, solver.hammingDistance(-1, 1));
    }

    @Test
    void returnsThirtyTwoWhenAllBitsDiffer(SolutionVariants.Solver solver) {
        assertEquals(32, solver.hammingDistance(-1, ~(-1))); // -1 vs 0
    }

}
