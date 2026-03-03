package p461_hamming_distance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void returnsTwoForExampleCase() {
        assertEquals(2, s.hammingDistance(4, 1));   // 100 vs 001
    }

    @Test
    void returnsOneForSingleBitDifference() {
        assertEquals(1, s.hammingDistance(3, 1));   // 011 vs 001
    }

    @Test
    void returnsZeroForIdenticalNumbers() {
        assertEquals(0, s.hammingDistance(7, 7));
    }

    @Test
    void returnsZeroForBothZero() {
        assertEquals(0, s.hammingDistance(0, 0));
    }

    @Test
    void returnsOneWhenOneIsZero() {
        assertEquals(1, s.hammingDistance(0, 1));
    }

    @Test
    void returnsThirtyOneForMaxIntAndZero() {
        assertEquals(31, s.hammingDistance(Integer.MAX_VALUE, 0));
    }

    @Test
    void returnsThirtyTwoForMinusOneAndZero() {
        assertEquals(32, s.hammingDistance(-1, 0));
    }

    @Test
    void returnsOneForMinValueAndZero() {
        assertEquals(1, s.hammingDistance(Integer.MIN_VALUE, 0));
    }

    @Test
    void handlesNegativeNumbersCorrectly() {
        assertEquals(31, s.hammingDistance(-1, 1));
    }

    @Test
    void returnsThirtyTwoWhenAllBitsDiffer() {
        assertEquals(32, s.hammingDistance(-1, ~(-1))); // -1 vs 0
    }

}
