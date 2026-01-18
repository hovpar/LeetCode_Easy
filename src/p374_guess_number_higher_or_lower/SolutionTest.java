package p374_guess_number_higher_or_lower;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void picksLowerBound() {
        Solution s = new Solution(1);
        assertEquals(1, s.guessNumber(1));
    }

    @Test
    void picksUpperBound() {
        int n = 10;
        Solution s = new Solution(n);
        assertEquals(n, s.guessNumber(n));
    }

    @Test
    void picksMiddle() {
        Solution s = new Solution(6);
        assertEquals(6, s.guessNumber(10));
    }

    @Test
    void worksWithLargeNAndNoOverflow() {
        int n = Integer.MAX_VALUE;
        int picked = 1_700_000_000;
        Solution s = new Solution(picked);
        assertEquals(picked, s.guessNumber(n));
    }

    @Test
    void randomSanityChecks() {
        assertEquals(5, new Solution(5).guessNumber(10));
        assertEquals(2, new Solution(2).guessNumber(2));
        assertEquals(9, new Solution(9).guessNumber(10));
    }

}
