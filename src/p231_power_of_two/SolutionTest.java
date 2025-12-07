package p231_power_of_two;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testOneIsPowerOfTwo() {
        assertTrue(s.isPowerOfTwo(1)); // smallest valid power of two
    }

    @Test
    void testSmallPowersOfTwo() {
        assertTrue(s.isPowerOfTwo(2));
        assertTrue(s.isPowerOfTwo(4));
        assertTrue(s.isPowerOfTwo(8));
    }

    @Test
    void testLargePowersOfTwo() {
        assertTrue(s.isPowerOfTwo(1024));
        assertTrue(s.isPowerOfTwo(1 << 30)); // largest within constraints (around 1e9)
    }

    @Test
    void testZeroAndNegatives() {
        assertFalse(s.isPowerOfTwo(0)); // special case
        assertFalse(s.isPowerOfTwo(-1)); // negatives can't be powers of two
        assertFalse(s.isPowerOfTwo(-16));
    }

    @Test
    void testNonPowersOfTwo() {
        assertFalse(s.isPowerOfTwo(3));
        assertFalse(s.isPowerOfTwo(5));
        assertFalse(s.isPowerOfTwo(12));
        assertFalse(s.isPowerOfTwo(1023)); // edge case just below 1024
    }

    @Test
    void testMaxIntAndNearMax() {
        assertFalse(s.isPowerOfTwo(Integer.MAX_VALUE));
        assertFalse(s.isPowerOfTwo(Integer.MAX_VALUE - 1));
    }

}
