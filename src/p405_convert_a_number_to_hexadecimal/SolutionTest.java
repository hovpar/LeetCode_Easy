package p405_convert_a_number_to_hexadecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testPositiv() {
        assertEquals("1a", s.toHex(26));
    }

    @Test
    void testNegative() {
        assertEquals("ffffffff", s.toHex(-1));
    }

    @Test
    void testZero() {
        assertEquals("0", s.toHex(0));
    }

    @Test
    void testSingleDigitPositive() {
        assertEquals("f", s.toHex(15));
    }

    @Test
    void testPowerOfTwo() {
        assertEquals("10", s.toHex(16));
    }

    @Test
    void testMaxInt() {
        assertEquals("7fffffff", s.toHex(Integer.MAX_VALUE));
    }

    @Test
    void testMinInt() {
        assertEquals("80000000", s.toHex(Integer.MIN_VALUE));
    }

    @Test
    void testNegativeSmall() {
        assertEquals("fffffffe", s.toHex(-2));
    }

    @Test
    void testRandomPositive() {
        assertEquals("1234abcd", s.toHex(0x1234ABCD));
    }

    @Test
    void testTrailingZeros() {
        assertEquals("1000", s.toHex(4096));
    }
}
