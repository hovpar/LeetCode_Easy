package p693_binary_number_with_alternating_bits;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
                arguments(
                        Named.of(
                                "iterative bit comparison solver",
                                new SolutionVariants.IterativeBitComparisonSolver())),
                arguments(Named.of("xor big pattern solver", new SolutionVariants.XorBitPatternSolver())));
    }

    @TestEachSolver
    void testSingleBit(SolutionVariants.Solver solver) {
        assertTrue(solver.hasAlternatingBits(1)); // 1
    }

    @TestEachSolver
    void testAlternatingBitsStartingWithZero(SolutionVariants.Solver solver) {
        assertTrue(solver.hasAlternatingBits(10)); // 1010
        assertTrue(solver.hasAlternatingBits(42)); // 101010
    }

    @TestEachSolver
    void testLongerAlternatingSequence(SolutionVariants.Solver solver) {
        assertTrue(solver.hasAlternatingBits(21)); // 10101
        assertTrue(solver.hasAlternatingBits(85)); // 1010101
    }

    @TestEachSolver
    void testAdjacentEqualBits(SolutionVariants.Solver solver) {
        assertFalse(solver.hasAlternatingBits(3)); // 11
        assertFalse(solver.hasAlternatingBits(4)); // 100
        assertFalse(solver.hasAlternatingBits(11)); // 1011
        assertFalse(solver.hasAlternatingBits(12)); // 1100
    }

    @TestEachSolver
    void testIntegerBoundary(SolutionVariants.Solver solver) {
        assertFalse(solver.hasAlternatingBits(Integer.MAX_VALUE));
    }

}
