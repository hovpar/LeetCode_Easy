package p219_contains_duplicate_ii;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testSimpleTrueCases() {
        assertTrue(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
        assertTrue(solution.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
        assertTrue(solution.containsNearbyDuplicate(new int[] { 99, 99 }, 2));
    }

    @Test
    void testSimpleFalseCases() {
        assertFalse(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
        assertFalse(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 4 }, 1));
        assertFalse(solution.containsNearbyDuplicate(new int[] { 1 }, 5));
    }

    @Test
    void testAdjacentDuplicates() {
        assertTrue(solution.containsNearbyDuplicate(new int[] { 4, 4, 4 }, 1));
    }

    @Test
    void testKZero() {
        // Only identical index pairs (i==j) allowed -> impossible -> always false
        assertFalse(solution.containsNearbyDuplicate(new int[] { 1, 1 }, 0));
    }

    @Test
    void testLargeK() {
        // k >= array length -> equivalent to: "any duplicates?"
        assertTrue(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 4, 2 }, 100));
    }

    @Test
    void testNegativeNumbers() {
        assertTrue(solution.containsNearbyDuplicate(new int[] { -1, -2, -3, -1 }, 3));
    }

    @Test
    void testNoDuplicatesAtAll() {
        assertFalse(solution.containsNearbyDuplicate(new int[] { 10, 20, 30, 40, 50 }, 10));
    }

    @Test
    void testDuplicateJustOutsideRange() {
        assertFalse(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 2));
    }

    // Timeout test for brute-force solution
    @Test
    @Timeout(value = 42, unit = TimeUnit.MILLISECONDS)
    void testBruteForceWouldTimeout() {
        int n = 20000; // 20k -> 20k * k nested loops
        int k = 10000;
        int[] bigArray = new int[n];

        // Fill with unique numbers so that brute force must check all pairs
        for (int i = 0; i < n; i++) {
            bigArray[i] = i;
        }

        // Should run quickly with the optimized sliding-window solution
        assertFalse(solution.containsNearbyDuplicate(bigArray, k));
    }

}
