package p461_hamming_distance;

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
        return Stream.of(new SolutionVariants.BitByBitShiftSolver(), new SolutionVariants.XorBitCountShiftSolver(),
                new SolutionVariants.KernighanBitCountSolver());
    }

    @SolverTest
    void returnsTwoForExampleCase(SolutionVariants.Solver solver) {
        assertEquals(2, solver.hammingDistance(4, 1));   // 100 vs 001
    }

    @SolverTest
    void returnsOneForSingleBitDifference(SolutionVariants.Solver solver) {
        assertEquals(1, solver.hammingDistance(3, 1));   // 011 vs 001
    }

    @SolverTest
    void returnsZeroForIdenticalNumbers(SolutionVariants.Solver solver) {
        assertEquals(0, solver.hammingDistance(7, 7));
    }

    @SolverTest
    void returnsZeroForBothZero(SolutionVariants.Solver solver) {
        assertEquals(0, solver.hammingDistance(0, 0));
    }

    @SolverTest
    void returnsOneWhenOneIsZero(SolutionVariants.Solver solver) {
        assertEquals(1, solver.hammingDistance(0, 1));
    }

    @SolverTest
    void returnsThirtyOneForMaxIntAndZero(SolutionVariants.Solver solver) {
        assertEquals(31, solver.hammingDistance(Integer.MAX_VALUE, 0));
    }

    @SolverTest
    void returnsThirtyTwoForMinusOneAndZero(SolutionVariants.Solver solver) {
        assertEquals(32, solver.hammingDistance(-1, 0));
    }

    @SolverTest
    void returnsOneForMinValueAndZero(SolutionVariants.Solver solver) {
        assertEquals(1, solver.hammingDistance(Integer.MIN_VALUE, 0));
    }

    @SolverTest
    void handlesNegativeNumbersCorrectly(SolutionVariants.Solver solver) {
        assertEquals(31, solver.hammingDistance(-1, 1));
    }

    @SolverTest
    void returnsThirtyTwoWhenAllBitsDiffer(SolutionVariants.Solver solver) {
        assertEquals(32, solver.hammingDistance(-1, ~(-1))); // -1 vs 0
    }

}
