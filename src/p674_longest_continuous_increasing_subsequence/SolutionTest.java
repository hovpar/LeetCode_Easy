package p674_longest_continuous_increasing_subsequence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void shouldReturnLongestContinuousIncreasingSubsequence() {
        assertEquals(3, s.findLengthOfLCIS(new int[] { 1, 3, 5, 4, 7 }));
    }

    @Test
    void shouldReturnOneWhenAllElementsAreEqual() {
        assertEquals(1, s.findLengthOfLCIS(new int[] { 2, 2, 2, 2, 2 }));
    }

    @Test
    void shouldReturnZeroForEmptyArray() {
        assertEquals(0, s.findLengthOfLCIS(new int[] {}));
    }

    @Test
    void shouldReturnOneForSingleElement() {
        assertEquals(1, s.findLengthOfLCIS(new int[] { 5 }));
    }

    @Test
    void shouldReturnArrayLengthWhenEntireArrayIsIncreasing() {
        assertEquals(5, s.findLengthOfLCIS(new int[] { 1, 2, 3, 4, 5 }));
    }

    @Test
    void shouldReturnOneWhenArrayIsStrictlyDecreasing() {
        assertEquals(1, s.findLengthOfLCIS(new int[] { 5, 4, 3, 2, 1 }));
    }

    @Test
    void shouldHandleIncreasingSequenceAtTheEnd() {
        assertEquals(4, s.findLengthOfLCIS(new int[] { 5, 1, 2, 3, 4 }));
    }

    @Test
    void shouldHandleIncreasingSequenceAtTheBeginning() {
        assertEquals(4, s.findLengthOfLCIS(new int[] { 1, 2, 3, 4, 0 }));
    }

    @Test
    void shouldHandleMultipleIncreasingSequences() {
        assertEquals(4, s.findLengthOfLCIS(new int[] { 1, 2, 3, 1, 2, 3, 4 }));
    }

    @Test
    void shouldResetSequenceWhenElementsAreEqual() {
        assertEquals(2, s.findLengthOfLCIS(new int[] { 1, 2, 2, 3 }));
    }

    @Test
    void shouldHandleNegativeNumbers() {
        assertEquals(4, s.findLengthOfLCIS(new int[] { -5, -4, -3, -2, -6 }));
    }

    @Test
    void shouldHandleMixedPositiveAndNegativeNumbers() {
        assertEquals(4, s.findLengthOfLCIS(new int[] { -2, -1, 0, 3, 2, 4 }));
    }
}
