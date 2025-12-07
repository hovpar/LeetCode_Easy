package p191_number_of_1_bits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testNo1Bits() {
        assertEquals(0, solution.hammingWeight(0));
    }

    @Test
    void test1() {
        assertEquals(3, solution.hammingWeight(11));
    }

    @Test
    void test2() {
        assertEquals(1, solution.hammingWeight(128));
    }

    @Test
    void test3() {
        assertEquals(30, solution.hammingWeight(2147483645));
    }
}
