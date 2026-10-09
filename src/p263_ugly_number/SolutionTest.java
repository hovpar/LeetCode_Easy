package p263_ugly_number;

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
                arguments(Named.of("iterative solver", new SolutionVariants.IterativeSolver())),
                arguments(Named.of("recutsive solver", new SolutionVariants.RecursiveSolver())));
    }

    @TestEachSolver
    void testValidPrimeFactors(SolutionVariants.Solver solver) {
        assertTrue(solver.isUgly(8)); // 2³
        assertTrue(solver.isUgly(27)); // 3³
        assertTrue(solver.isUgly(125)); // 5³
        assertTrue(solver.isUgly(30)); // 2*3*5
    }

    @TestEachSolver
    void testInputIsOne(SolutionVariants.Solver solver) {
        assertTrue(solver.isUgly(1));
    }

    @TestEachSolver
    void testInvalidPrimeFactors(SolutionVariants.Solver solver) {
        assertFalse(solver.isUgly(14));
        assertFalse(solver.isUgly(33));
    }

    @TestEachSolver
    void testLargeNonUglyNumber(SolutionVariants.Solver solver) {
        assertFalse(solver.isUgly(75600));
    }

    @TestEachSolver
    void testInputIsZero(SolutionVariants.Solver solver) {
        assertFalse(solver.isUgly(0));
    }

    @TestEachSolver
    void testInputIsNegative(SolutionVariants.Solver solver) {
        assertFalse(solver.isUgly(-1));
    }

}
