package p219_contains_duplicate_ii;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Timeout;
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
                arguments(Named.of("hashset solver", new SolutionVariants.HashSetSolver())));
    }

    @TestEachSolver
    void testSimpleTrueCases(SolutionVariants.Solver solver) {
        assertTrue(solver.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
        assertTrue(solver.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
        assertTrue(solver.containsNearbyDuplicate(new int[] { 99, 99 }, 2));
    }

    @TestEachSolver
    void testSimpleFalseCases(SolutionVariants.Solver solver) {
        assertFalse(solver.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
        assertFalse(solver.containsNearbyDuplicate(new int[] { 1, 2, 3, 4 }, 1));
        assertFalse(solver.containsNearbyDuplicate(new int[] { 1 }, 5));
    }

    @TestEachSolver
    void testAdjacentDuplicates(SolutionVariants.Solver solver) {
        assertTrue(solver.containsNearbyDuplicate(new int[] { 4, 4, 4 }, 1));
    }

    @TestEachSolver
    void testKZero(SolutionVariants.Solver solver) {
        // Only identical index pairs (i==j) allowed -> impossible -> always false
        assertFalse(solver.containsNearbyDuplicate(new int[] { 1, 1 }, 0));
    }

    @TestEachSolver
    void testLargeK(SolutionVariants.Solver solver) {
        // k >= array length -> equivalent to: "any duplicates?"
        assertTrue(solver.containsNearbyDuplicate(new int[] { 1, 2, 3, 4, 2 }, 100));
    }

    @TestEachSolver
    void testNegativeNumbers(SolutionVariants.Solver solver) {
        assertTrue(solver.containsNearbyDuplicate(new int[] { -1, -2, -3, -1 }, 3));
    }

    @TestEachSolver
    void testNoDuplicatesAtAll(SolutionVariants.Solver solver) {
        assertFalse(solver.containsNearbyDuplicate(new int[] { 10, 20, 30, 40, 50 }, 10));
    }

    @TestEachSolver
    void testDuplicateJustOutsideRange(SolutionVariants.Solver solver) {
        assertFalse(solver.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 2));
    }

    // Timeout test for brute-force solution
    @TestEachSolver
    @Timeout(value = 42, unit = TimeUnit.MILLISECONDS)
    void testBruteForceWouldTimeout(SolutionVariants.Solver solver) {
        int n = 20000; // 20k -> 20k * k nested loops
        int k = 10000;
        int[] bigArray = new int[n];

        // Fill with unique numbers so that brute force must check all pairs
        for (int i = 0; i < n; i++) {
            bigArray[i] = i;
        }

        // Should run quickly with the optimized sliding-window solution
        assertFalse(solver.containsNearbyDuplicate(bigArray, k));
    }

}
