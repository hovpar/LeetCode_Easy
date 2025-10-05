package _168ExcelSheetColumnTitle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testSingleLetter() {
        assertEquals("A", solution.convertToTitle(1));
    }

    @Test
    void testTwoLetters() {
        assertEquals("AB", solution.convertToTitle(28));
    }

    @Test
    void testHighValue() {
        assertEquals("ZY", solution.convertToTitle(701));
    }

    @Test
    void testBoundaryCaseAZ() {
        assertEquals("AZ", solution.convertToTitle(52));
    }
}
