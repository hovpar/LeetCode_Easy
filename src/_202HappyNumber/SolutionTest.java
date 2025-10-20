package _202HappyNumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testTrue() {
        assertTrue(solution.isHappy(19));
    }

    @Test
    void testFalse() {
        assertFalse(solution.isHappy(4));
    }

    @Test
    void testSevenOnes() {
        assertTrue(solution.isHappy(1111111));
    }

}
