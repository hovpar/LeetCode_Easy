package p268_missing_number;

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
                arguments(Named.of("sum difference solver", new SolutionVariants.SumDifferenceSolver())),
                arguments(Named.of("xor operator solver", new SolutionVariants.XORSolver())));
    }

    @TestEachSolver
    void testArrayIsUnsorted(SolutionVariants.Solver solver) {
        int[] nums = { 3, 0, 1 };
        assertEquals(2, solver.missingNumber(nums));
    }

    @TestEachSolver
    void testZeroAndOnePresent(SolutionVariants.Solver solver) {
        int[] nums = { 0, 1 };
        assertEquals(2, solver.missingNumber(nums));
    }

    @TestEachSolver
    void testArrayContainsMultipleElements(SolutionVariants.Solver solver) {
        int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        assertEquals(8, solver.missingNumber(nums));
    }

    @TestEachSolver
    void testZeroIsMissing(SolutionVariants.Solver solver) {
        int[] nums = { 1, 2 };
        assertEquals(0, solver.missingNumber(nums));
    }

    @TestEachSolver
    void testArrayIsEmpty(SolutionVariants.Solver solver) {
        int[] nums = {};
        assertEquals(0, solver.missingNumber(nums));
    }

    @TestEachSolver
    void testSingleElementIsOne(SolutionVariants.Solver solver) {
        int[] nums = { 1 };
        assertEquals(0, solver.missingNumber(nums));
    }

    @TestEachSolver
    void testSingleElementIsZero(SolutionVariants.Solver solver) {
        int[] nums = { 0 };
        assertEquals(1, solver.missingNumber(nums));
    }

}
