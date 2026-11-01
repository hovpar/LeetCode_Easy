package p704_binary_search;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldReturnMinusOneWhenTargetDoesNotExist() {
        int[] nums = { -1, 0, 3, 5, 9, 12 };

        assertAll(
                () -> assertEquals(-1, s.search(nums, 13)),
                () -> assertEquals(-1, s.search(nums, -2)),
                () -> assertEquals(-1, s.search(nums, 4)),
                () -> assertEquals(-1, s.search(nums, 10)));
    }

    @Test
    void shouldReturnCorrectIndexForExistingTarget() {
        int[] nums = { -1, 0, 3, 5, 9, 12 };

        assertEquals(4, s.search(nums, 9));
    }

    @Test
    void shouldFindFirstElement() {
        int[] nums = { -1, 0, 3, 5, 9, 12 };

        assertEquals(0, s.search(nums, -1));
    }

    @Test
    void shouldFindLastElement() {
        int[] nums = { -1, 0, 3, 5, 9, 12 };

        assertEquals(5, s.search(nums, 12));
    }

    @Test
    void shouldFindMiddleElement() {
        int[] nums = { -1, 0, 3, 5, 9 };

        assertEquals(2, s.search(nums, 3));
    }

    @Test
    void shouldHandleSingleElementArray() {
        int[] nums = { 5 };

        assertEquals(0, s.search(nums, 5));
        assertEquals(-1, s.search(nums, 3));
    }

    @Test
    void shouldHandleEmptyArray() {
        int[] nums = {};

        assertEquals(-1, s.search(nums, 5));
    }

    @Test
    void shouldHandleTwoElements() {
        int[] nums = { 2, 4 };

        assertEquals(0, s.search(nums, 2));
        assertEquals(1, s.search(nums, 4));
        assertEquals(-1, s.search(nums, 3));
    }

    @Test
    void shouldHandleNegativeNumbers() {
        int[] nums = { -10, -7, -3, -1 };

        assertEquals(1, s.search(nums, -7));
        assertEquals(-1, s.search(nums, -5));
    }

    @Test
    void shouldHandleIntegerBoundaries() {
        int[] nums = { Integer.MIN_VALUE, 0, Integer.MAX_VALUE };

        assertEquals(0, s.search(nums, Integer.MIN_VALUE));
        assertEquals(2, s.search(nums, Integer.MAX_VALUE));
    }

}
