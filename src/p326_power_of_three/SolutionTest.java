package p326_power_of_three;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testNegativeNumber() {
        assertFalse(s.isPowerOfThree(-1));
    }

    @Test
    void testZero() {
        assertFalse(s.isPowerOfThree(0));
    }

    @Test
    void testOne() {
        assertTrue(s.isPowerOfThree(1)); // 3^0
    }

    @Test
    void testSmallPowersOfThree() {
        assertTrue(s.isPowerOfThree(3));
        assertTrue(s.isPowerOfThree(9));
        assertTrue(s.isPowerOfThree(27));
    }

    @Test
    void testLargePowerOfThree() {
        assertTrue(s.isPowerOfThree(1162261467)); // 3^19
    }

    @Test
    void testNonPowersOfThree() {
        assertFalse(s.isPowerOfThree(2));
        assertFalse(s.isPowerOfThree(10));
        assertFalse(s.isPowerOfThree(45));
    }

    @Test
    void testIntegerMaxValue() {
        assertFalse(s.isPowerOfThree(Integer.MAX_VALUE));
    }

}
