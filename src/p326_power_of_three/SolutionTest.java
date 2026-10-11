package p326_power_of_three;

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
                arguments(Named.of("iterative division solver", new SolutionVariants.IterativeDivisionSolver())),
                arguments(
                        Named.of(
                                "largest power divisibility solver",
                                new SolutionVariants.LargestPowerDivisibilitySolver())));
    }

    @TestEachSolver
    void testNegativeNumber(SolutionVariants.Solver solver) {
        assertFalse(solver.isPowerOfThree(-1));
    }

    @TestEachSolver
    void testZero(SolutionVariants.Solver solver) {
        assertFalse(solver.isPowerOfThree(0));
    }

    @TestEachSolver
    void testOne(SolutionVariants.Solver solver) {
        assertTrue(solver.isPowerOfThree(1)); // 3^0
    }

    @TestEachSolver
    void testSmallPowersOfThree(SolutionVariants.Solver solver) {
        assertTrue(solver.isPowerOfThree(3));
        assertTrue(solver.isPowerOfThree(9));
        assertTrue(solver.isPowerOfThree(27));
    }

    @TestEachSolver
    void testLargePowerOfThree(SolutionVariants.Solver solver) {
        assertTrue(solver.isPowerOfThree(1162261467)); // 3^19
        assertFalse(solver.isPowerOfThree(1162261466));
        assertFalse(solver.isPowerOfThree(1162261468));
    }

    @TestEachSolver
    void testNonPowersOfThree(SolutionVariants.Solver solver) {
        assertFalse(solver.isPowerOfThree(2));
        assertFalse(solver.isPowerOfThree(10));
        assertFalse(solver.isPowerOfThree(45));
    }

    @TestEachSolver
    void testIntegerMaxValue(SolutionVariants.Solver solver) {
        assertFalse(solver.isPowerOfThree(Integer.MAX_VALUE));
    }

}
