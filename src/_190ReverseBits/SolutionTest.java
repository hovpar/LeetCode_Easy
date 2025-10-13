package _190ReverseBits;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals(964176192, solution.reverseBits1(43261596));

    }

    @Test
    void test2() {
        assertEquals(1073741822, solution.reverseBits1(2147483644));

    }

}
