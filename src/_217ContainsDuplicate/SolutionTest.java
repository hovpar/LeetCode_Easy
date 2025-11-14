package _217ContainsDuplicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testFalse() {
        int[] array = { 1, 2, 3, 4 };
        assertFalse(solution.containsDuplicate(array));
    }

    @Test
    void testTrue() {
        int[] array1 = { 1, 2, 3, 1 };
        int[] array2 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        assertTrue(solution.containsDuplicate(array1));
        assertTrue(solution.containsDuplicate(array2));
    }

    @Test
    void testEmptyArray() {
        int[] array = {};
        assertFalse(solution.containsDuplicate(array));
    }

    @Test
    void testSingleElement() {
        int[] array = { 42 };
        assertFalse(solution.containsDuplicate(array));
    }

    @Test
    void testTwoSameElements() {
        int[] array = { 5, 5 };
        assertTrue(solution.containsDuplicate(array));
    }

    @Test
    void testNegativeNumbers() {
        int[] array = { -1, -2, -3, -1 };
        assertTrue(solution.containsDuplicate(array));
    }

    @Test
    void testZeros() {
        int[] array = { 0, 1, 2, 3, 0 };
        assertTrue(solution.containsDuplicate(array));
    }

    @Test
    void testLargeArrayNoDuplicates() {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        assertFalse(solution.containsDuplicate(array));
    }

    @Test
    void testLargeArrayWithDuplicate() {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        array[9999] = 123; // create a duplicate
        assertTrue(solution.containsDuplicate(array));
    }

    @Test
    void testUnsortedWithDuplicate() {
        int[] array = { 9, 4, 6, 2, 8, 6 };
        assertTrue(solution.containsDuplicate(array));
    }

    @Test
    void testMaxValue() {
        int[] array = { Integer.MAX_VALUE, 1, 2, Integer.MAX_VALUE };
        assertTrue(solution.containsDuplicate(array));
    }

    @Test
    void testMinValue() {
        int[] array = { Integer.MIN_VALUE, 3, 4, Integer.MIN_VALUE };
        assertTrue(solution.containsDuplicate(array));
    }

    @Test
    void testBruteForceTimeout() {
        int size = 50_000;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = i;
        }

        // Expect timeout under 200 ms (or whatever threshold you want)
        assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            solution.containsDuplicate(nums);
        });
    }
}
