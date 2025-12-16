package p268_missing_number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testArrayIsUnsorted() {
        int[] nums = { 3, 0, 1 };
        assertEquals(2, s.missingNumber(nums));
    }

    @Test
    void testZeroAndOnePresent() {
        int[] nums = { 0, 1 };
        assertEquals(2, s.missingNumber(nums));
    }

    @Test
    void testArrayContainsMultipleElements() {
        int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        assertEquals(8, s.missingNumber(nums));
    }

    @Test
    void testZeroIsMissing() {
        int[] nums = { 1, 2 };
        assertEquals(0, s.missingNumber(nums));
    }

    @Test
    void testArrayIsEmpty() {
        int[] nums = {};
        assertEquals(0, s.missingNumber(nums));
    }

    @Test
    void testSingleElementIsOne() {
        int[] nums = { 1 };
        assertEquals(0, s.missingNumber(nums));
    }

    @Test
    void testSingleElementIsZero() {
        int[] nums = { 0 };
        assertEquals(1, s.missingNumber(nums));
    }

}
