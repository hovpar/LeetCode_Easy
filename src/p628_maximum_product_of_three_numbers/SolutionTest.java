package p628_maximum_product_of_three_numbers;

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
                arguments(Named.of("sorting solver", new SolutionVariants.SortingSolver())),
                arguments(Named.of("enumeration solver", new SolutionVariants.LineratScanSolver())),
                arguments(Named.of("brute-force solver", new SolutionVariants.BruteForceSolver())));
    }

    @TestEachSolver
    void testPositiveNumbers(SolutionVariants.Solver solver) {
        int[] nums = { 1, 2, 3 };

        assertEquals(6, solver.maximumProduct(nums));
    }

    @TestEachSolver
    void shouldReturnProductOfOnlyThreeNumbers(SolutionVariants.Solver solver) {
        int[] nums = { 1, 2, 3, 4 };

        assertEquals(24, solver.maximumProduct(nums));
    }

    @TestEachSolver
    void shouldReturnProductOfOnlyThreeNegativeNumbers(SolutionVariants.Solver solver) {
        int[] nums = { -1, -2, -3 };

        assertEquals(-6, solver.maximumProduct(nums));
    }

    @TestEachSolver
    void shouldHandlePositiveAndNegativeNumbers(SolutionVariants.Solver solver) {
        int[] nums = { -100, -98, -1, 2, 3, 4 };

        assertEquals(39200, solver.maximumProduct(nums));
    }

    @TestEachSolver
    void shouldUseTwoSmallestNegativeNumbersAndLargestPositiveNumber(SolutionVariants.Solver solver) {
        int[] nums = { -10, -10, 1, 2, 3 };

        assertEquals(300, solver.maximumProduct(nums));
    }

    @TestEachSolver
    void shouldHandleTwoNegativeNumbers(SolutionVariants.Solver solver) {
        int[] nums = { -5, -4, 1, 2, 3 };

        assertEquals(60, solver.maximumProduct(nums));
    }

    @TestEachSolver
    void shouldHandleZeros(SolutionVariants.Solver solver) {
        int[] nums = { -5, -4, 0, 1, 2 };

        assertEquals(40, solver.maximumProduct(nums));
    }

    @TestEachSolver
    void shouldHandleMultipleZeros(SolutionVariants.Solver solver) {
        int[] nums = { -5, 0, 0, 1, 2 };

        assertEquals(0, solver.maximumProduct(nums));
    }

    @TestEachSolver
    void shouldHandleAllZeros(SolutionVariants.Solver solver) {
        int[] nums = { 0, 0, 0, 0 };

        assertEquals(0, solver.maximumProduct(nums));
    }

    @TestEachSolver
    void shouldHandleDuplicatePositiveNumbers(SolutionVariants.Solver solver) {
        int[] nums = { 2, 2, 2, 3 };

        assertEquals(12, solver.maximumProduct(nums));
    }

    @TestEachSolver
    void shouldHandleDuplicateNegativeNumbers(SolutionVariants.Solver solver) {
        int[] nums = { -10, -10, -10, -2 };

        assertEquals(-200, solver.maximumProduct(nums));
    }

}
