package p476_number_complement;

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
        return Stream.of(new SolutionVariants.BitMaskConstructionSolver(),
                new SolutionVariants.HighestOneBitMaskSolver());
    }

    @SolverTest
    void returnsZeroForOne(SolutionVariants.Solver solver) {
        assertEquals(0, solver.findComplement(1));
    }

    @SolverTest
    void returnsTwoForFive(SolutionVariants.Solver solver) {
        assertEquals(2, solver.findComplement(5)); // 101 -> 010
    }

    @SolverTest
    void returnsOneForTwo(SolutionVariants.Solver solver) {
        assertEquals(1, solver.findComplement(2)); // 10 -> 01
    }

    @SolverTest
    void returnsZeroForAllBitsSetThree(SolutionVariants.Solver solver) {
        assertEquals(0, solver.findComplement(3)); // 11 -> 00
    }

    @SolverTest
    void returnsThreeForFour(SolutionVariants.Solver solver) {
        assertEquals(3, solver.findComplement(4)); // 100 -> 011
    }

    @SolverTest
    void returnsZeroForSeven(SolutionVariants.Solver solver) {
        assertEquals(0, solver.findComplement(7)); // 111 -> 000
    }

    @SolverTest
    void returnsSevenForEight(SolutionVariants.Solver solver) {
        assertEquals(7, solver.findComplement(8)); // 1000 -> 0111
    }

    @SolverTest
    void returnsFiveForTen(SolutionVariants.Solver solver) {
        assertEquals(5, solver.findComplement(10)); // 1010 -> 0101
    }

    @SolverTest
    void returnsZeroForThirtyOne(SolutionVariants.Solver solver) {
        assertEquals(0, solver.findComplement(31)); // 11111 -> 00000
    }

    @SolverTest
    void returnsThirtyOneForThirtyTwo(SolutionVariants.Solver solver) {
        assertEquals(31, solver.findComplement(32)); // 100000 -> 011111
    }

    @SolverTest
    void returnsPositiveValueForLargerNumber(SolutionVariants.Solver solver) {
        assertEquals(260, solver.findComplement(763)); // 1011111011 -> 0100000100
    }

    @SolverTest
    void returnsZeroForMaxConstraintValue(SolutionVariants.Solver solver) {
        assertEquals(0, solver.findComplement(1_073_741_823)); // 2^30 - 1, all 30 bits are 1
    }

}
