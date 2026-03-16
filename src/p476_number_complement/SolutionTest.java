package p476_number_complement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    static Stream<SolutionVariants.Solver> solvers() {
        return Stream.of(new SolutionVariants.BitMaskConstructionSolver(),
                new SolutionVariants.HighestOneBitMaskSolver());
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void returnsZeroForOne(SolutionVariants.Solver solver) {
        assertEquals(0, solver.findComplement(1));
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void returnsTwoForFive(SolutionVariants.Solver solver) {
        assertEquals(2, solver.findComplement(5)); // 101 -> 010
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void returnsOneForTwo(SolutionVariants.Solver solver) {
        assertEquals(1, solver.findComplement(2)); // 10 -> 01
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void returnsZeroForAllBitsSetThree(SolutionVariants.Solver solver) {
        assertEquals(0, solver.findComplement(3)); // 11 -> 00
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void returnsThreeForFour(SolutionVariants.Solver solver) {
        assertEquals(3, solver.findComplement(4)); // 100 -> 011
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void returnsZeroForSeven(SolutionVariants.Solver solver) {
        assertEquals(0, solver.findComplement(7)); // 111 -> 000
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void returnsSevenForEight(SolutionVariants.Solver solver) {
        assertEquals(7, solver.findComplement(8)); // 1000 -> 0111
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void returnsFiveForTen(SolutionVariants.Solver solver) {
        assertEquals(5, solver.findComplement(10)); // 1010 -> 0101
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void returnsZeroForThirtyOne(SolutionVariants.Solver solver) {
        assertEquals(0, solver.findComplement(31)); // 11111 -> 00000
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void returnsThirtyOneForThirtyTwo(SolutionVariants.Solver solver) {
        assertEquals(31, solver.findComplement(32)); // 100000 -> 011111
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void returnsPositiveValueForLargerNumber(SolutionVariants.Solver solver) {
        assertEquals(260, solver.findComplement(763)); // 1011111011 -> 0100000100
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void returnsZeroForMaxConstraintValue(SolutionVariants.Solver solver) {
        assertEquals(0, solver.findComplement(1_073_741_823)); // 2^30 - 1, all 30 bits are 1
    }

}
