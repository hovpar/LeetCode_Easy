package p342_power_of_four;

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
                arguments(Named.of("power enumeration solver", new SolutionVariants.PowerEnumerationSolver())),
                arguments(Named.of("bit manipulation solver", new SolutionVariants.BitManipulationSolver())));
    }

    @TestEachSolver
    void testNegativeNumber(SolutionVariants.Solver solver) {
        assertFalse(solver.isPowerOfFour(-1));
    }

    @TestEachSolver
    void testZero(SolutionVariants.Solver solver) {
        assertFalse(solver.isPowerOfFour(0));
    }

    @TestEachSolver
    void testOne(SolutionVariants.Solver solver) {
        assertTrue(solver.isPowerOfFour(1)); // 4^0
    }

    @TestEachSolver
    void testSmallPowersOfFour(SolutionVariants.Solver solver) {
        assertTrue(solver.isPowerOfFour(4));
        assertTrue(solver.isPowerOfFour(16));
        assertTrue(solver.isPowerOfFour(64));
    }

    @TestEachSolver
    void testLargePowerOfFour(SolutionVariants.Solver solver) {
        assertTrue(solver.isPowerOfFour(1073741824)); // 4^15
    }

    @TestEachSolver
    void testNonPowersOfFour(SolutionVariants.Solver solver) {
        assertFalse(solver.isPowerOfFour(2));
        assertFalse(solver.isPowerOfFour(10));
        assertFalse(solver.isPowerOfFour(45));
    }

    @TestEachSolver
    void testIntegerMaxValue(SolutionVariants.Solver solver) {
        assertFalse(solver.isPowerOfFour(Integer.MAX_VALUE));
    }

}
