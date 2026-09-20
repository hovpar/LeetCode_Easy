package p645_set_mismatch;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldFindDuplicateAndMissingNumber() {
        int[] nums = { 2, 2 };
        int[] expected = { 2, 1 };

        assertArrayEquals(expected, s.findErrorNums(nums));
    }

    @Test
    void shouldFindDuplicateAndMissingNumberInMiddle() {
        int[] nums = { 1, 2, 2, 4 };
        int[] expected = { 2, 3 };

        assertArrayEquals(expected, s.findErrorNums(nums));
    }

    @Test
    void shouldHandleDuplicateOne() {
        int[] nums = { 1, 1 };
        int[] expected = { 1, 2 };

        assertArrayEquals(expected, s.findErrorNums(nums));
    }

    @Test
    void shouldHandleDuplicateAtEnd() {
        int[] nums = { 1, 2, 3, 4, 5, 6, 6 };
        int[] expected = { 6, 7 };

        assertArrayEquals(expected, s.findErrorNums(nums));
    }

    @Test
    void shouldHandleMissingNumberAtEnd() {
        int[] nums = { 1, 2, 3, 4, 4 };
        int[] expected = { 4, 5 };

        assertArrayEquals(expected, s.findErrorNums(nums));
    }

    @Test
    void shouldHandleMissingNumberAtBeginning() {
        int[] nums = { 2, 2, 3, 4 };
        int[] expected = { 2, 1 };

        assertArrayEquals(expected, s.findErrorNums(nums));
    }

    @Test
    void shouldHandleMissingNumberInMiddle() {
        int[] nums = { 1, 2, 4, 4, 5 };
        int[] expected = { 4, 3 };

        assertArrayEquals(expected, s.findErrorNums(nums));
    }

    @Test
    void shouldHandleLargerInput() {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 8, 10 };
        int[] expected = { 8, 9 };

        assertArrayEquals(expected, s.findErrorNums(nums));
    }

    @Test
    void shouldHandleTwoElementArray() {
        int[] nums = { 1, 1 };
        int[] expected = { 1, 2 };

        assertArrayEquals(expected, s.findErrorNums(nums));
    }

    @Test
    void shouldFindDuplicateAndMissingNumberWhenTheyAreAdjacent() {
        int[] nums = { 1, 2, 3, 4, 4, 6 };
        int[] expected = { 4, 5 };

        assertArrayEquals(expected, s.findErrorNums(nums));
    }

}
