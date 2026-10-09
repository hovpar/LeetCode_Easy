package p258_add_digits;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
                arguments(Named.of("recursive digit sum solver", new SolutionVariants.RecursiveDigitSumSolver())),
                arguments(Named.of("digital root solver", new SolutionVariants.DigitalRootSolver())));
    }

    @TestEachSolver
    void testSingleDigit(SolutionVariants.Solver solver) {
        assertEquals(7, solver.addDigits(7));
    }

    @TestEachSolver
    void testMultipleReductions(SolutionVariants.Solver solver) {
        // 999 -> 27 -> 9
        assertEquals(9, solver.addDigits(999));
    }

    @TestEachSolver
    void testTwoDigitNumberRequiringReduction(SolutionVariants.Solver solver) {
        // 19 -> 1
        assertEquals(1, solver.addDigits(19));
    }

    @TestEachSolver
    void testPowerOfTen(SolutionVariants.Solver solver) {
        // 1000 -> 1
        assertEquals(1, solver.addDigits(1000));
    }

    @TestEachSolver
    void testAllNines(SolutionVariants.Solver solver) {
        // 99 -> 18 -> 9
        assertEquals(9, solver.addDigits(99));
    }

    @TestEachSolver
    void testMaxIntValue(SolutionVariants.Solver solver) {
        // Integer.MAX_VALUE = 2147483647
        // Sum = 46 -> 10 -> 1
        assertEquals(1, solver.addDigits(Integer.MAX_VALUE));
    }

    @TestEachSolver
    void testRepeatedZeros(SolutionVariants.Solver solver) {
        assertEquals(5, solver.addDigits(500000));
    }

    @TestEachSolver
    void testAnotherTypicalCase(SolutionVariants.Solver solver) {
        // 18 -> 9
        assertEquals(9, solver.addDigits(18));
    }
}
