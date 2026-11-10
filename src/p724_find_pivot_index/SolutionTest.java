package p724_find_pivot_index;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldFindPivotIndexInMiddle() {
        assertEquals(3, s.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
    }

    @Test
    void shouldFindPivotIndexAtStart() {
        assertEquals(0, s.pivotIndex(new int[] { 2, 1, -1 }));
    }

    @Test
    void shouldReturnMinusOneWhenNoPivotExists() {
        assertEquals(-1, s.pivotIndex(new int[] { 2, 1, -1, 1 }));
    }

    @Test
    void shouldFindPivotIndexAtEnd() {
        assertEquals(2, s.pivotIndex(new int[] { 1, -1, 2 }));
    }

    @Test
    void shouldReturnZeroForSingleElement() {
        assertEquals(0, s.pivotIndex(new int[] { 5 }));
    }

    @Test
    void shouldFindPivotWhenAllElementsAreZero() {
        assertEquals(0, s.pivotIndex(new int[] { 0, 0, 0, 0 }));
    }

    @Test
    void shouldFindFirstPivotWhenMultipleExist() {
        assertEquals(0, s.pivotIndex(new int[] { 0, 0, 0 }));
    }

    @Test
    void shouldHandleNegativeNumbers() {
        assertEquals(1, s.pivotIndex(new int[] { -1, 2, -1 }));
    }

    @Test
    void shouldHandleMixedPositiveAndNegativeNumbers() {
        assertEquals(2, s.pivotIndex(new int[] { -1, -1, 0, 1, -3 }));
    }

    @Test
    void shouldHandleTwoElementsWithoutPivot() {
        assertEquals(-1, s.pivotIndex(new int[] { 1, 2 }));
    }

}
