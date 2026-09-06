package p217_contains_duplicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;
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
                arguments(Named.of("brute force solver", new SolutionVariants.BruteForceSolver())),
                arguments(Named.of("array sort solver", new SolutionVariants.ArraySortSolver())),
                arguments(Named.of("hashset solver", new SolutionVariants.HashSetSolver())));
    }

    @TestEachSolver
    void testFalse(SolutionVariants.Solver solver) {
        int[] array = { 1, 2, 3, 4 };
        assertFalse(solver.containsDuplicate(array));
    }

    @TestEachSolver
    void testTrue(SolutionVariants.Solver solver) {
        int[] array1 = { 1, 2, 3, 1 };
        int[] array2 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        assertTrue(solver.containsDuplicate(array1));
        assertTrue(solver.containsDuplicate(array2));
    }

    @TestEachSolver
    void testEmptyArray(SolutionVariants.Solver solver) {
        int[] array = {};
        assertFalse(solver.containsDuplicate(array));
    }

    @TestEachSolver
    void testSingleElement(SolutionVariants.Solver solver) {
        int[] array = { 42 };
        assertFalse(solver.containsDuplicate(array));
    }

    @TestEachSolver
    void testTwoSameElements(SolutionVariants.Solver solver) {
        int[] array = { 5, 5 };
        assertTrue(solver.containsDuplicate(array));
    }

    @TestEachSolver
    void testNegativeNumbers(SolutionVariants.Solver solver) {
        int[] array = { -1, -2, -3, -1 };
        assertTrue(solver.containsDuplicate(array));
    }

    @TestEachSolver
    void testZeros(SolutionVariants.Solver solver) {
        int[] array = { 0, 1, 2, 3, 0 };
        assertTrue(solver.containsDuplicate(array));
    }

    @TestEachSolver
    void testLargeArrayNoDuplicates(SolutionVariants.Solver solver) {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        assertFalse(solver.containsDuplicate(array));
    }

    @TestEachSolver
    void testLargeArrayWithDuplicate(SolutionVariants.Solver solver) {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        array[9999] = 123; // create a duplicate
        assertTrue(solver.containsDuplicate(array));
    }

    @TestEachSolver
    void testUnsortedWithDuplicate(SolutionVariants.Solver solver) {
        int[] array = { 9, 4, 6, 2, 8, 6 };
        assertTrue(solver.containsDuplicate(array));
    }

    @TestEachSolver
    void testMaxValue(SolutionVariants.Solver solver) {
        int[] array = { Integer.MAX_VALUE, 1, 2, Integer.MAX_VALUE };
        assertTrue(solver.containsDuplicate(array));
    }

    @TestEachSolver
    void testMinValue(SolutionVariants.Solver solver) {
        int[] array = { Integer.MIN_VALUE, 3, 4, Integer.MIN_VALUE };
        assertTrue(solver.containsDuplicate(array));
    }

    @TestEachSolver
    void testBruteForceTimeout(SolutionVariants.Solver solver) {
        int size = 50_000;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = i;
        }

        // Expect timeout under 200 ms (or whatever threshold you want)
        assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            solver.containsDuplicate(nums);
        });
    }
}
