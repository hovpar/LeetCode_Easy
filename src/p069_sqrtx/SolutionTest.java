package p069_sqrtx;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testZero() {
        assertEquals(0, s.mySqrt(0));
    }

    @Test
    void testLargeNumber() {
        assertEquals(46340, s.mySqrt(2147483647));
    }

    @Test
    void testPerfectSquare() {
        assertEquals(10, s.mySqrt(100)); // Perfect square test
    }

    @Test
    void testSmallNumber() {
        assertEquals(1, s.mySqrt(1)); // Smallest non-zero input
    }

    @Test
    void testNonPerfectSquare() {
        assertEquals(3, s.mySqrt(15)); // Non-perfect square number
    }

    @Test
    void testJustBelowPerfectSquare() {
        assertEquals(9, s.mySqrt(99));
    }

}
