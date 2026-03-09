package p476_number_complement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void returnsZeroForOne() {
        assertEquals(0, s.findComplement(1));
    }

    @Test
    void returnsTwoForFive() {
        assertEquals(2, s.findComplement(5)); // 101 -> 010
    }

    @Test
    void returnsOneForTwo() {
        assertEquals(1, s.findComplement(2)); // 10 -> 01
    }

    @Test
    void returnsZeroForAllBitsSetThree() {
        assertEquals(0, s.findComplement(3)); // 11 -> 00
    }

    @Test
    void returnsThreeForFour() {
        assertEquals(3, s.findComplement(4)); // 100 -> 011
    }

    @Test
    void returnsZeroForSeven() {
        assertEquals(0, s.findComplement(7)); // 111 -> 000
    }

    @Test
    void returnsSevenForEight() {
        assertEquals(7, s.findComplement(8)); // 1000 -> 0111
    }

    @Test
    void returnsFiveForTen() {
        assertEquals(5, s.findComplement(10)); // 1010 -> 0101
    }

    @Test
    void returnsZeroForThirtyOne() {
        assertEquals(0, s.findComplement(31)); // 11111 -> 00000
    }

    @Test
    void returnsThirtyOneForThirtyTwo() {
        assertEquals(31, s.findComplement(32)); // 100000 -> 011111
    }

    @Test
    void returnsPositiveValueForLargerNumber() {
        assertEquals(260, s.findComplement(763)); // 1011111011 -> 0100000100
    }

    @Test
    void returnsZeroForMaxConstraintValue() {
        assertEquals(0, s.findComplement(1_073_741_823)); // 2^30 - 1, all 30 bits are 1
    }

}
