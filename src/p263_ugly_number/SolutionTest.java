package p263_ugly_number;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testValidPrimeFactors() {
        assertTrue(s.isUgly(8)); // 2³
        assertTrue(s.isUgly(27)); // 3³
        assertTrue(s.isUgly(125)); // 5³
        assertTrue(s.isUgly(30)); // 2*3*5
    }

    @Test
    void testInputIsOne() {
        assertTrue(s.isUgly(1));
    }

    @Test
    void testInvalidPrimeFactors() {
        assertFalse(s.isUgly(14));
        assertFalse(s.isUgly(33));
    }

    @Test
    void testLargeNonUglyNumber() {
        assertFalse(s.isUgly(75600));
    }

    @Test
    void testInputIsZero() {
        assertFalse(s.isUgly(0));
    }

    @Test
    void testInputIsNegative() {
        assertFalse(s.isUgly(-1));
    }

}
