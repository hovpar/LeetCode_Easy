package p258_add_digits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testSingleDigit() {
        assertEquals(7, s.addDigits(7));
    }

    @Test
    void testMultipleReductions() {
        // 999 -> 27 -> 9
        assertEquals(9, s.addDigits(999));
    }

    @Test
    void testPowerOfTen() {
        // 1000 -> 1
        assertEquals(1, s.addDigits(1000));
    }

    @Test
    void testAllNines() {
        // 99 -> 18 -> 9
        assertEquals(9, s.addDigits(99));
    }

    @Test
    void testMaxIntValue() {
        // Integer.MAX_VALUE = 2147483647
        // Sum = 46 -> 10 -> 1
        assertEquals(1, s.addDigits(Integer.MAX_VALUE));
    }

    @Test
    void testRepeatedZeros() {
        assertEquals(5, s.addDigits(500000));
    }

    @Test
    void testAnotherTypicalCase() {
        // 18 -> 9
        assertEquals(9, s.addDigits(18));
    }
}
