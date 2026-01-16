package p367_valid_perfect_square;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testZeroIsPerfectSquare() {
        assertTrue(s.isPerfectSquare(0)); // 0 * 0
    }

    @Test
    void testOneIsPerfectSquare() {
        assertTrue(s.isPerfectSquare(1)); // 1 * 1
    }

    @Test
    void testSmallPerfectSquares() {
        assertTrue(s.isPerfectSquare(4));
        assertTrue(s.isPerfectSquare(9));
        assertTrue(s.isPerfectSquare(16));
        assertTrue(s.isPerfectSquare(25));
    }

    @Test
    void testInvalidPerfectSquares() {
        assertFalse(s.isPerfectSquare(2));
        assertFalse(s.isPerfectSquare(3));
        assertFalse(s.isPerfectSquare(5));
        assertFalse(s.isPerfectSquare(14));
    }

    @Test
    void testNumbersJustBelowAndAboveSquare() {
        // around 15^2 = 225
        assertFalse(s.isPerfectSquare(224));
        assertTrue(s.isPerfectSquare(225));
        assertFalse(s.isPerfectSquare(226));
    }

    @Test
    void testLargePerfectSquareNearIntMax() {
        // 46340^2 = 2,147,395,600 (fits in int)
        assertTrue(s.isPerfectSquare(2147395600));
    }

    @Test
    void testLargeNonSquaresNearLargeSquare() {
        assertFalse(s.isPerfectSquare(2147395599));
        assertFalse(s.isPerfectSquare(2147395601));
    }

    @Test
    void testIntMaxIsNotPerfectSquare() {
        assertFalse(s.isPerfectSquare(Integer.MAX_VALUE)); // 2,147,483,647
    }

    @Test
    void testPrimeIsNotPerfectSquare() {
        assertFalse(s.isPerfectSquare(97));
    }
}
