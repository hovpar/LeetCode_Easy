package p136_single_number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void case1() {
        int[] array = { 2, 2, 1 };

        assertEquals(1, solution.singleNumber(array));
    }

    @Test
    void case2() {
        int[] array = { 4, 1, 2, 1, 2 };

        assertEquals(4, solution.singleNumber(array));
    }

    @Test
    void case3() {
        int[] array = { 1 };

        assertEquals(1, solution.singleNumber(array));
    }
}
