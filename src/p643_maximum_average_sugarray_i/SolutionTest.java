package p643_maximum_average_sugarray_i;

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
                arguments(Named.of("brute-force solver", new SolutionVariants.BruteForceSolver())),
                arguments(Named.of("sliding window solver", new SolutionVariants.SlidingWindowSolver())));
    }

    @TestEachSolver
    void shouldHandleSingleNegativeNumber(SolutionVariants.Solver solver) {
        int[] nums = { -1 };
        assertEquals(-1.0, solver.findMaxAverage(nums, 1), 1e-9);
    }

    @TestEachSolver
    void shouldHandleSinglePositiveNumber(SolutionVariants.Solver solver) {
        int[] nums = { 5 };
        assertEquals(5.0, solver.findMaxAverage(nums, 1), 1e-9);
    }

    @TestEachSolver
    void shouldReturnMaxAverage(SolutionVariants.Solver solver) {
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        assertEquals(12.75, solver.findMaxAverage(nums, 4), 1e-9);
    }

    @TestEachSolver
    void shouldHandleKEqualToArrayLength(SolutionVariants.Solver solver) {
        int[] nums = { 1, 2, 3, 4, 5 };
        assertEquals(3.0, solver.findMaxAverage(nums, 5), 1e-9);
    }

    @TestEachSolver
    void shouldHandleKEqualToOne(SolutionVariants.Solver solver) {
        int[] nums = { -5, 10, -2, 7, 3 };
        assertEquals(10.0, solver.findMaxAverage(nums, 1), 1e-9);
    }

    @TestEachSolver
    void shouldHandleAllNegativeNumbers(SolutionVariants.Solver solver) {
        int[] nums = { -10, -20, -30, -40 };
        assertEquals(-15.0, solver.findMaxAverage(nums, 2), 1e-9);
    }

    @TestEachSolver
    void shouldHandleAllZeroes(SolutionVariants.Solver solver) {
        int[] nums = { 0, 0, 0, 0, 0 };
        assertEquals(0.0, solver.findMaxAverage(nums, 3), 1e-9);
    }

    @TestEachSolver
    void shouldHandlePositiveAndNegativeNumbers(SolutionVariants.Solver solver) {
        int[] nums = { -5, 4, -2, 10, -1, 3 };
        assertEquals(4.5, solver.findMaxAverage(nums, 2), 1e-9);
    }

    @TestEachSolver
    void shouldFindMaximumWindowAtBeginning(SolutionVariants.Solver solver) {
        int[] nums = { 10, 10, 10, 1, 1, 1 };
        assertEquals(10.0, solver.findMaxAverage(nums, 3), 1e-9);
    }

    @TestEachSolver
    void shouldFindMaximumWindowAtEnd(SolutionVariants.Solver solver) {
        int[] nums = { 1, 1, 1, 10, 10, 10 };
        assertEquals(10.0, solver.findMaxAverage(nums, 3), 1e-9);
    }

    @TestEachSolver
    void shouldHandleFractionalAverage(SolutionVariants.Solver solver) {
        int[] nums = { 1, 2, 4 };
        assertEquals(3.0, solver.findMaxAverage(nums, 2), 1e-9);
    }

    @TestEachSolver
    void shouldHandleRepeatedValues(SolutionVariants.Solver solver) {
        int[] nums = { 5, 5, 5, 5, 5 };
        assertEquals(5.0, solver.findMaxAverage(nums, 3), 1e-9);
    }

    @TestEachSolver
    void shouldUpdateWindowCorrectly(SolutionVariants.Solver solver) {
        int[] nums = { 1, 2, 3, 100, 4, 5 };

        assertEquals(52.0, solver.findMaxAverage(nums, 2), 1e-9);
    }

    @TestEachSolver
    void shouldHandleIntegerMaxValuesWithoutOverflow(SolutionVariants.Solver solver) {
        int[] nums = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
        assertEquals(Integer.MAX_VALUE, solver.findMaxAverage(nums, 3), 1e-9);
    }

    @TestEachSolver
    void shouldHandleIntegerMinValuesWithoutOverflow(SolutionVariants.Solver solver) {
        int[] nums = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
        assertEquals(Integer.MIN_VALUE, solver.findMaxAverage(nums, 3), 1e-9);
    }

    @TestEachSolver
    void shouldHandleLargePositiveSumWithoutIntegerOverflow(SolutionVariants.Solver solver) {
        int[] nums = { Integer.MAX_VALUE, Integer.MAX_VALUE, 0 };
        assertEquals(Integer.MAX_VALUE, solver.findMaxAverage(nums, 2), 1e-9);
    }

}
