package p342_power_of_four;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testNegativeNumber() {
        assertFalse(s.isPowerOfFour(-1));
    }

    @Test
    void testZero() {
        assertFalse(s.isPowerOfFour(0));
    }

    @Test
    void testOne() {
        assertTrue(s.isPowerOfFour(1)); // 4^0
    }

    @Test
    void testSmallPowersOfFour() {
        assertTrue(s.isPowerOfFour(4));
        assertTrue(s.isPowerOfFour(16));
        assertTrue(s.isPowerOfFour(64));
    }

    @Test
    void testLargePowerOfFour() {
        assertTrue(s.isPowerOfFour(1073741824)); // 4^15
    }

    @Test
    void testNonPowersOfFour() {
        assertFalse(s.isPowerOfFour(2));
        assertFalse(s.isPowerOfFour(10));
        assertFalse(s.isPowerOfFour(45));
    }

    @Test
    void testIntegerMaxValue() {
        assertFalse(s.isPowerOfFour(Integer.MAX_VALUE));
    }

}
