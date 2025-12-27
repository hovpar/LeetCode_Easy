package p338_counting_bits;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void testZero() {
        assertArrayEquals(new int[] { 0 }, s.countBits(0));
    }

    @Test
    void testOne() {
        assertArrayEquals(new int[] { 0, 1 }, s.countBits(1));
    }

    @Test
    void testTwo() {
        assertArrayEquals(new int[] { 0, 1, 1 }, s.countBits(2));
    }

    @Test
    void testThree() {
        assertArrayEquals(new int[] { 0, 1, 1, 2 }, s.countBits(3));
    }

    @Test
    void testFive() {
        int[] expected = { 0, 1, 1, 2, 1, 2 };
        assertArrayEquals(expected, s.countBits(5));
    }

    @Test
    void testLargeInput() {
        int n = 1000;
        int[] result = s.countBits(n);

        assertEquals(n + 1, result.length);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2, result[3]);
    }

    @Test
    void testBitCountProperty() {
        int n = 50;
        int[] result = s.countBits(n);

        for (int i = 1; i <= n; i++) {
            assertEquals(result[i >> 1] + (i & 1), result[i]);
        }
    }

    @Test
    void testBitCountUpperBound() {
        int n = 100;
        int[] result = s.countBits(n);

        for (int i = 0; i <= n; i++) {
            assertTrue(result[i] <= Integer.bitCount(i));
        }
    }

}
