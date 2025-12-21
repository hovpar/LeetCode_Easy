package p283_move_zeroes;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testSingleElement() {
        int[] nums = { 0 };
        s.moveZeroes(nums);
        int[] expected = { 0 };
        assertArrayEquals(expected, nums);
    }

    @Test
    void testNoNeedToMove() {
        int[] nums = { 1, 0 };
        s.moveZeroes(nums);
        int[] expected = { 1, 0 };
        assertArrayEquals(expected, nums);
    }

    @Test
    void testOnlyTwoElements() {
        int[] nums = { 0, 1 };
        s.moveZeroes(nums);
        int[] expected = { 1, 0 };
        assertArrayEquals(expected, nums);
    }

    @Test
    void testZeroesAtEnd() {
        int[] nums = { 0, 1, 0, 0, 0 };
        s.moveZeroes(nums);
        int[] expected = { 1, 0, 0, 0, 0 };
        assertArrayEquals(expected, nums);
    }

    @Test
    void testMultipleMoves() {
        int[] nums = { 0, 1, 0, 3, 12 };
        s.moveZeroes(nums);
        int[] expected = { 1, 3, 12, 0, 0 };
        assertArrayEquals(expected, nums);
    }

    @Test
    void testNoZeros() {
        int[] nums = { 1, 2, 3, 4 };
        s.moveZeroes(nums);
        assertArrayEquals(new int[] { 1, 2, 3, 4 }, nums);
    }

    @Test
    void testAllZeros() {
        int[] nums = { 0, 0, 0 };
        s.moveZeroes(nums);
        assertArrayEquals(new int[] { 0, 0, 0 }, nums);
    }

    @Test
    void testZerosAlreadyAtEnd() {
        int[] nums = { 1, 2, 3, 0, 0 };
        s.moveZeroes(nums);
        assertArrayEquals(new int[] { 1, 2, 3, 0, 0 }, nums);
    }

    @Test
    void testWithNegativeNumbers() {
        int[] nums = { 0, -1, 0, -3, 2 };
        s.moveZeroes(nums);
        assertArrayEquals(new int[] { -1, -3, 2, 0, 0 }, nums);
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        s.moveZeroes(nums);
        assertArrayEquals(new int[] {}, nums);
    }

}
