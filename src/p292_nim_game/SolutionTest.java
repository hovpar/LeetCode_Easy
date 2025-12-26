package p292_nim_game;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    // Losing positions (multiples of 4)
    @Test
    void testLosingPositions() {
        assertFalse(s.canWinNim(4));
        assertFalse(s.canWinNim(8));
        assertFalse(s.canWinNim(12));
        assertFalse(s.canWinNim(100));
    }

    // Winning positions (not multiples of 4)
    @Test
    void testWinningPositions() {
        assertTrue(s.canWinNim(1));
        assertTrue(s.canWinNim(2));
        assertTrue(s.canWinNim(3));
        assertTrue(s.canWinNim(5));
        assertTrue(s.canWinNim(7));
        assertTrue(s.canWinNim(9));
    }

    // Boundary values near multiples of 4
    @Test
    void testAroundMultipleOfFour() {
        assertTrue(s.canWinNim(3));
        assertFalse(s.canWinNim(4));
        assertTrue(s.canWinNim(5));
    }

    // Large input values (int boundary)
    @Test
    void testLargeValues() {
        assertFalse(s.canWinNim(Integer.MAX_VALUE - 3)); // divisible by 4
        assertTrue(s.canWinNim(Integer.MAX_VALUE - 2));
        assertTrue(s.canWinNim(Integer.MAX_VALUE - 1));
        assertTrue(s.canWinNim(Integer.MAX_VALUE));
    }

}
