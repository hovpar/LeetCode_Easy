package p367_valid_perfect_square;

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
                arguments(Named.of("odd number sum solver", new SolutionVariants.OddNumberSumSolver())),
                arguments(Named.of("binary search solver", new SolutionVariants.BinarySearchSolver())));
    }

    @TestEachSolver
    void testZeroIsPerfectSquare(SolutionVariants.Solver solver) {
        assertTrue(solver.isPerfectSquare(0)); // 0 * 0
    }

    @TestEachSolver
    void testOneIsPerfectSquare(SolutionVariants.Solver solver) {
        assertTrue(solver.isPerfectSquare(1)); // 1 * 1
    }

    @TestEachSolver
    void testSmallPerfectSquares(SolutionVariants.Solver solver) {
        assertTrue(solver.isPerfectSquare(4));
        assertTrue(solver.isPerfectSquare(9));
        assertTrue(solver.isPerfectSquare(16));
        assertTrue(solver.isPerfectSquare(25));
    }

    @TestEachSolver
    void testInvalidPerfectSquares(SolutionVariants.Solver solver) {
        assertFalse(solver.isPerfectSquare(2));
        assertFalse(solver.isPerfectSquare(3));
        assertFalse(solver.isPerfectSquare(5));
        assertFalse(solver.isPerfectSquare(14));
    }

    @TestEachSolver
    void testNumbersJustBelowAndAboveSquare(SolutionVariants.Solver solver) {
        // around 15^2 = 225
        assertFalse(solver.isPerfectSquare(224));
        assertTrue(solver.isPerfectSquare(225));
        assertFalse(solver.isPerfectSquare(226));
    }

    @TestEachSolver
    void testLargePerfectSquareNearIntMax(SolutionVariants.Solver solver) {
        // 46340^2 = 2,147,395,600 (fits in int)
        assertTrue(solver.isPerfectSquare(2147395600));
    }

    @TestEachSolver
    void testLargeNonSquaresNearLargeSquare(SolutionVariants.Solver solver) {
        assertFalse(solver.isPerfectSquare(2147395599));
        assertFalse(solver.isPerfectSquare(2147395601));
    }

    @TestEachSolver
    void testIntMaxIsNotPerfectSquare(SolutionVariants.Solver solver) {
        assertFalse(solver.isPerfectSquare(Integer.MAX_VALUE)); // 2,147,483,647
    }

    @TestEachSolver
    void testPrimeIsNotPerfectSquare(SolutionVariants.Solver solver) {
        assertFalse(solver.isPerfectSquare(97));
    }
}
